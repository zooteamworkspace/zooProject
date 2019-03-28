package com.zoo.zooApplication.service.impl;

import com.zoo.zooApplication.converter.FieldBookingDOToResponseConverter;
import com.zoo.zooApplication.dao.model.FieldBookingDO;
import com.zoo.zooApplication.dao.repository.FieldBookingRepository;
import com.zoo.zooApplication.request.CreateBookingRequest;
import com.zoo.zooApplication.request.validator.BookingRequestValidator;
import com.zoo.zooApplication.response.FieldBooking;
import com.zoo.zooApplication.service.BookingService;
import com.zoo.zooApplication.util.DateTimeUtil;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private FieldBookingRepository fieldBookingRepository;

    private FieldBookingDOToResponseConverter fieldBookingDOToResponseConverter;

    private BookingRequestValidator bookingRequestValidator;

    @Inject
    public BookingServiceImpl(FieldBookingRepository fieldBookingRepository, FieldBookingDOToResponseConverter fieldBookingDOToResponseConverter, BookingRequestValidator bookingRequestValidator) {
        this.fieldBookingRepository = fieldBookingRepository;
        this.fieldBookingDOToResponseConverter = fieldBookingDOToResponseConverter;
        this.bookingRequestValidator = bookingRequestValidator;
    }

    @Override
    public FieldBooking findBookingById(String bookingId) {
        bookingRequestValidator.validateBookingId(bookingId);
        Optional<FieldBookingDO> fieldBookingDO = fieldBookingRepository.findById(NumberUtils.toLong(bookingId));
        FieldBooking fieldBooking = null;
        if (fieldBookingDO.isPresent()) {
            fieldBooking = fieldBookingDOToResponseConverter.convert(fieldBookingDO.get());
        }
        return fieldBooking;
    }

    @Override
    public FieldBooking createBooking(CreateBookingRequest bookingRequest) {
        bookingRequestValidator.validateCreateBookingRequest(bookingRequest);
        ZonedDateTime timeIn = DateTimeUtil.parseISO8601Format(bookingRequest.getTimeIn());
        FieldBookingDO.FieldBookingDOBuilder doBuilder = FieldBookingDO.builder()
                .fieldId(bookingRequest.getFieldId())
                .timeIn(timeIn)
                .timeOut(timeIn.plusMinutes(bookingRequest.getDuration()))
                .bookerPhone(bookingRequest.getBookerPhone())
                .bookerEmail(bookingRequest.getBookerEmail())
                .bookerName(bookingRequest.getBookerName())
                .priceAmount(bookingRequest.getPriceAmount())
                .currencyId("VND"); // NOTE; hard-code to VND

        if (bookingRequest.getFieldId() != null && bookingRequest.getFieldId() > 0) {
            // TODO: find courtId and fieldType from fieldID and ignore the extra data
            doBuilder.fieldId(bookingRequest.getFieldId());
        } else {
            doBuilder.courtId(bookingRequest.getCourtId());
            doBuilder.fieldType(bookingRequest.getFieldType());
        }

        FieldBookingDO result = fieldBookingRepository.save(doBuilder.build());
        return fieldBookingDOToResponseConverter.convert(result);
    }
}

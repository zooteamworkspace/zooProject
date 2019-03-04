package com.zoo.bookingService.service.impl;

import com.zoo.bookingService.converter.FieldBookingDOToResponseConverter;
import com.zoo.bookingService.dao.model.FieldBookingDO;
import com.zoo.bookingService.dao.repository.FieldBookingRepository;
import com.zoo.bookingService.response.FieldBooking;
import com.zoo.bookingService.service.BookingService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private FieldBookingRepository fieldBookingRepository;

    private FieldBookingDOToResponseConverter fieldBookingDOToResponseConverter;

    @Inject
    public BookingServiceImpl(FieldBookingRepository fieldBookingRepository, FieldBookingDOToResponseConverter fieldBookingDOToResponseConverter) {
        this.fieldBookingRepository = fieldBookingRepository;
        this.fieldBookingDOToResponseConverter = fieldBookingDOToResponseConverter;
    }

    @Override
    public FieldBooking findBookingById(long bookingId) {
        Optional<FieldBookingDO> fieldBookingDO = fieldBookingRepository.findById(bookingId);
        FieldBooking fieldBooking = null;
        if (fieldBookingDO.isPresent()) {
            fieldBooking = fieldBookingDOToResponseConverter.convert(fieldBookingDO.get());
        }
        return fieldBooking;
    }
}

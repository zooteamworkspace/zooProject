package com.zoo.zooApplication.service.impl;

import com.zoo.zooApplication.converter.FieldBookingDOToResponseConverter;
import com.zoo.zooApplication.dao.model.FieldBookingDO;
import com.zoo.zooApplication.dao.repository.FieldBookingRepository;
import com.zoo.zooApplication.request.CreateBookingRequest;
import com.zoo.zooApplication.response.FieldBooking;
import com.zoo.zooApplication.service.BookingService;
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

    @Override
    public FieldBooking createBooking(CreateBookingRequest bookingRequest) {
        return FieldBooking.builder().id(123).build();
    }
}

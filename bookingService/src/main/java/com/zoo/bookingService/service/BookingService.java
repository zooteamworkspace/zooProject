package com.zoo.bookingService.service;

import com.zoo.bookingService.response.FieldBooking;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookingService {

    FieldBooking findBookingById(long bookingId);

    List<FieldBooking> findAllBookingByFieldId(long fieldId, Pageable pageable);
}

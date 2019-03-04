package com.zoo.bookingService.service;

import com.zoo.bookingService.response.FieldBooking;

public interface BookingService {

    FieldBooking findBookingById(long bookingId);
}

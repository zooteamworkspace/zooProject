package com.zoo.zooApplication.service;

import com.zoo.zooApplication.request.CreateBookingRequest;
import com.zoo.zooApplication.response.FieldBooking;

public interface BookingService {

    FieldBooking findBookingById(long bookingId);

    FieldBooking createBooking(CreateBookingRequest bookingRequest);
}

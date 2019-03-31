package com.zoo.zooApplication.service;

import com.zoo.zooApplication.request.CreateBookingRequest;
import com.zoo.zooApplication.response.FieldBooking;

public interface BookingService {

    FieldBooking findBookingById(String bookingId);

    FieldBooking createBooking(CreateBookingRequest bookingRequest);
}

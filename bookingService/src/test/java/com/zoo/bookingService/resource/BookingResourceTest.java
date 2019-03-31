package com.zoo.bookingService.resource;

import com.zoo.bookingService.response.FieldBooking;
import com.zoo.bookingService.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingResourceTest {

    @Mock
    private BookingService mockBookingService;

    @InjectMocks
    private BookingResource bookingResource;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindBookingByIdFound() {
        FieldBooking mockResponse = mock(FieldBooking.class);
        when(mockBookingService.findBookingById(123l)).thenReturn(mockResponse);
        assertEquals(mockResponse, bookingResource.findById("123"));
    }

}
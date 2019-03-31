package com.zoo.bookingService.service.impl;

import com.zoo.bookingService.converter.FieldBookingDOToResponseConverter;
import com.zoo.bookingService.dao.model.FieldBookingDO;
import com.zoo.bookingService.dao.repository.FieldBookingRepository;
import com.zoo.bookingService.response.FieldBooking;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingServiceImplTest {

    @Mock
    private FieldBookingRepository fieldBookingRepository;

    @Mock
    private FieldBookingDOToResponseConverter fieldBookingDOToResponseConverter;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findBookingById() {
        BookingServiceImpl serviceImpl = new BookingServiceImpl(fieldBookingRepository, fieldBookingDOToResponseConverter);
        Optional<FieldBookingDO> mockDO = Optional.of(mock(FieldBookingDO.class));
        when(fieldBookingRepository.findById(123L)).thenReturn(mockDO);
        FieldBooking mockResponse = mock(FieldBooking.class);
        when(fieldBookingDOToResponseConverter.convert(mockDO.get())).thenReturn(mockResponse);

        assertEquals(mockResponse, serviceImpl.findBookingById(123L));
    }
}
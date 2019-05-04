package com.zoo.zooApplication.service.impl;

import com.zoo.zooApplication.converter.FieldBookingDOToResponseConverter;
import com.zoo.zooApplication.dao.model.FieldBookingDO;
import com.zoo.zooApplication.dao.repository.FieldBookingRepository;
import com.zoo.zooApplication.exception.InvalidRequestException;
import com.zoo.zooApplication.request.CreateBookingRequest;
import com.zoo.zooApplication.request.SearchFieldBookingRequest;
import com.zoo.zooApplication.request.validator.BookingRequestValidator;
import com.zoo.zooApplication.response.FieldBooking;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BookingServiceImplTest {

    @Mock
    private FieldBookingRepository fieldBookingRepository;

    @Mock
    private FieldBookingDOToResponseConverter fieldBookingDOToResponseConverter;

    @Mock
    private BookingRequestValidator bookingRequestValidator;

    private BookingServiceImpl bookingService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        bookingService = new BookingServiceImpl(fieldBookingRepository, fieldBookingDOToResponseConverter, bookingRequestValidator);
    }

    @Test
    public void testFindBookingByIdValid() {
        Optional<FieldBookingDO> mockDO = Optional.of(mock(FieldBookingDO.class));
        when(fieldBookingRepository.findById(123L)).thenReturn(mockDO);
        FieldBooking mockResponse = mock(FieldBooking.class);
        when(fieldBookingDOToResponseConverter.convert(mockDO.get())).thenReturn(mockResponse);

        assertEquals(mockResponse, bookingService.findBookingById("123"));
    }

    @Test(expected = InvalidRequestException.class)
    public void testFindBookingByIdInvalid() {
        doThrow(new InvalidRequestException("abc")).when(bookingRequestValidator).validateBookingId("abc");
        bookingService.findBookingById("abc");
    }

    @Test
    public void testFindBookingByFieldId(){
        Example<FieldBookingDO> mockExampleBookingDO = Example.of(FieldBookingDO.builder().fieldId(123L).build());
        Page<FieldBookingDO> mockListDO = mock(Page.class);
        SearchFieldBookingRequest mockSearchRequest = mock(SearchFieldBookingRequest.class);
        when(SearchFieldBookingRequest.builder().fieldId("123").limit(2).offset(1).build()).thenReturn(mockSearchRequest);
        when(fieldBookingRepository.findAll(mockExampleBookingDO, PageRequest.of(0,2)))
                .thenReturn(mockListDO);
        List<FieldBooking> mockResponse = mockListDO.stream().map(fieldBookingDOToResponseConverter::convert)
                .collect(Collectors.toList());
        assertEquals(mockResponse,bookingService.findAllBookingByFieldId(mockSearchRequest));
    }

    @Test(expected = InvalidRequestException.class)
    public void testCreateBookingInvalidRequest() {
        CreateBookingRequest testRequest = mock(CreateBookingRequest.class);
        doThrow(new InvalidRequestException("")).when(bookingRequestValidator).validateCreateBookingRequest(testRequest);
        bookingService.createBooking(testRequest);
    }

    @Test
    public void testCreateBookingValidRequest() {
        CreateBookingRequest testRequest = mock(CreateBookingRequest.class);
        when(testRequest.getTimeIn()).thenReturn("2019-03-10T15:16:15Z");
        ArgumentCaptor<FieldBookingDO> argumentCaptor = ArgumentCaptor.forClass(FieldBookingDO.class);
        FieldBookingDO mockDO = mock(FieldBookingDO.class);
        when(fieldBookingRepository.save(argumentCaptor.capture())).thenReturn(mockDO);
        FieldBooking mockResponse = mock(FieldBooking.class);
        when(fieldBookingDOToResponseConverter.convert(mockDO)).thenReturn(mockResponse);
        doNothing().when(bookingRequestValidator).validateCreateBookingRequest(testRequest);
        assertEquals(mockResponse, bookingService.createBooking(testRequest));
    }

    @Test
    public void testCreateBookingValidRequestVerifyBookerName() {
        CreateBookingRequest testRequest = mock(CreateBookingRequest.class);
        when(testRequest.getBookerName()).thenReturn("abc");
        FieldBookingDO requestDO = fieldRequestHelper(testRequest);
        assertEquals("abc", requestDO.getBookerName());
    }

    @Test
    public void testCreateBookingValidRequestVerifyBookerEmail() {
        CreateBookingRequest testRequest = mock(CreateBookingRequest.class);
        when(testRequest.getBookerEmail()).thenReturn("abc@gmail.com");
        FieldBookingDO requestDO = fieldRequestHelper(testRequest);
        assertEquals("abc@gmail.com", requestDO.getBookerEmail());
    }

    @Test
    public void testCreateBookingValidRequestVerifyBookerPhone() {
        CreateBookingRequest testRequest = mock(CreateBookingRequest.class);
        when(testRequest.getBookerPhone()).thenReturn("123456789");
        FieldBookingDO requestDO = fieldRequestHelper(testRequest);
        assertEquals("123456789", requestDO.getBookerPhone());
    }

    @Test
    public void testCreateBookingValidRequestVerifyPrice() {
        CreateBookingRequest testRequest = mock(CreateBookingRequest.class);
        when(testRequest.getPriceAmount()).thenReturn(100000.00);
        FieldBookingDO requestDO = fieldRequestHelper(testRequest);
        assertEquals("VND", requestDO.getCurrencyId());
        assertEquals(Double.valueOf(100000.00), requestDO.getPriceAmount());
    }

    @Test
    public void testCreateBookingValidRequestVerifyFieldId() {
        CreateBookingRequest testRequest = mock(CreateBookingRequest.class);
        when(testRequest.getFieldId()).thenReturn(123L);
        FieldBookingDO requestDO = fieldRequestHelper(testRequest);
        assertEquals(Long.valueOf(123L), requestDO.getFieldId());
        // TODO verify courtID and fieldType autoFilled
    }

    @Test
    public void testCreateBookingValidRequestVerifyCourtIdAndFieldTypeNoField() {
        CreateBookingRequest testRequest = mock(CreateBookingRequest.class);
        when(testRequest.getCourtId()).thenReturn(123L);
        when(testRequest.getFieldType()).thenReturn("FIELD_5");
        FieldBookingDO requestDO = fieldRequestHelper(testRequest);
        assertEquals(Long.valueOf(123L), requestDO.getCourtId());
        assertEquals("FIELD_5", requestDO.getFieldType());
    }

    @Test
    public void testCreateBookingValidRequestVerifyCourtIdAndFieldTypeNoFieldZero() {
        CreateBookingRequest testRequest = mock(CreateBookingRequest.class);
        when(testRequest.getFieldId()).thenReturn(0L);
        when(testRequest.getCourtId()).thenReturn(123L);
        when(testRequest.getFieldType()).thenReturn("FIELD_5");
        FieldBookingDO requestDO = fieldRequestHelper(testRequest);
        assertEquals(Long.valueOf(123L), requestDO.getCourtId());
        assertEquals("FIELD_5", requestDO.getFieldType());
    }

    @Test
    public void testCreateBookingValidRequestVerifyTime() {
        CreateBookingRequest testRequest = mock(CreateBookingRequest.class);
        when(testRequest.getTimeIn()).thenReturn("2019-03-10T15:16:15Z");
        when(testRequest.getDuration()).thenReturn(90);
        FieldBookingDO requestDO = fieldRequestHelper(testRequest);
        assertEquals(ZonedDateTime.of(LocalDateTime.of(2019, 03, 10, 15, 16, 15), ZoneId.of("UTC")), requestDO.getTimeIn());
        assertEquals(requestDO.getTimeOut(), requestDO.getTimeIn().plusMinutes(90));

    }

    private FieldBookingDO fieldRequestHelper(CreateBookingRequest testRequest) {
        // basic stub as required
        when(testRequest.getTimeIn()).thenReturn("2019-03-10T15:16:15Z");
        ArgumentCaptor<FieldBookingDO> argumentCaptor = ArgumentCaptor.forClass(FieldBookingDO.class);
        FieldBookingDO mockDO = mock(FieldBookingDO.class);
        when(fieldBookingRepository.save(argumentCaptor.capture())).thenReturn(mockDO);
        doNothing().when(bookingRequestValidator).validateCreateBookingRequest(testRequest);
        bookingService.createBooking(testRequest);
        return argumentCaptor.getValue();
    }
}
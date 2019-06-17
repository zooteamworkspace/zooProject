package com.zoo.zooApplication.service.impl;

import com.zoo.zooApplication.converter.CourtDOToResponseConverter;
import com.zoo.zooApplication.dao.model.CourtDO;
import com.zoo.zooApplication.dao.model.FieldDO;
import com.zoo.zooApplication.dao.repository.CourtRepository;
import com.zoo.zooApplication.dao.repository.FieldRepository;
import com.zoo.zooApplication.request.CreateCourtRequest;
import com.zoo.zooApplication.request.CreateFieldRequest;
import com.zoo.zooApplication.request.FieldRequest;
import com.zoo.zooApplication.response.Court;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CourtAndFieldServiceImplTest {

    @Mock
    private CourtRepository courtRepository;

    @Mock
    private FieldRepository fieldRepository;

    @Mock
    private CourtDOToResponseConverter courtDOToResponseConverter;

    private CourtAndFieldServiceImpl courtAndFieldService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        courtAndFieldService = new CourtAndFieldServiceImpl(courtRepository, fieldRepository, courtDOToResponseConverter);
    }

    @Test
    public void testCreateCourt() {
        CourtDO mockCourtDO = mock(CourtDO.class);
        when(courtRepository.save(any(CourtDO.class))).thenReturn(mockCourtDO);

        CreateCourtRequest mockRequest = new CreateCourtRequest();
        Court response = mock(Court.class);
        when(courtDOToResponseConverter.convert(mockCourtDO)).thenReturn(response);
        assertEquals(response, courtAndFieldService.createCourt(mockRequest));
    }

    @Test
    public void testCreateCourtVerifyInput() {
        CourtDO mockCourtDO = mock(CourtDO.class);
        ArgumentCaptor<CourtDO> courtDOArgumentCaptor = ArgumentCaptor.forClass(CourtDO.class);
        when(courtRepository.save(courtDOArgumentCaptor.capture())).thenReturn(mockCourtDO);

        CreateCourtRequest mockRequest = new CreateCourtRequest();
        mockRequest.setCourtName("testName");
        mockRequest.setCourtAddress("testAddress");
        mockRequest.setCourtPhone("testPhone");
        courtAndFieldService.createCourt(mockRequest);
        CourtDO courtDO = courtDOArgumentCaptor.getValue();
        assertNotNull(courtDO);
        assertEquals("testName", courtDO.getCourtName());
        assertEquals("testAddress", courtDO.getCourtAddress());
        assertEquals("testPhone", courtDO.getCourtPhone());
        assertTrue(courtDO.getFields().isEmpty());
    }

    @Test
    public void testFindCourtById() {
        CourtDO mockCourt = mock(CourtDO.class);
        when(courtRepository.findById(123L)).thenReturn(Optional.of(mockCourt));
        Court response = mock(Court.class);
        when(courtDOToResponseConverter.convert(mockCourt)).thenReturn(response);
        assertEquals(response, courtAndFieldService.findCourtById("123"));
    }

    @Test
    public void testFindCourtByFieldId() {
        CourtDO mockCourt = mock(CourtDO.class);
        FieldDO mockField = mock(FieldDO.class);
        when(mockField.getCourt()).thenReturn(mockCourt);
        when(fieldRepository.findById(123L)).thenReturn(Optional.of(mockField));
        Court response = mock(Court.class);
        when(courtDOToResponseConverter.convert(mockCourt)).thenReturn(response);
        assertEquals(response, courtAndFieldService.findCourtByFieldId("123"));
    }

    @Test
    public void testAddFieldToCourt() {
        CreateFieldRequest fieldRequest = new CreateFieldRequest();
        FieldRequest request1 = new FieldRequest();
        request1.setFieldName("testName1");
        request1.setFieldType("testType1");

        FieldRequest request2 = new FieldRequest();
        request2.setFieldName("testName2");
        request2.setFieldType("testType2");

        FieldRequest request3 = new FieldRequest();
        request3.setFieldName("testName3");
        request3.setFieldType("testType3");
        request3.setSubFieldIds(Arrays.asList("1", "2"));

        fieldRequest.setFieldRequests(Arrays.asList(request1, request2, request3));

        CourtDO courtDO = mock(CourtDO.class);
        ArgumentCaptor<FieldDO> fieldCaptor = ArgumentCaptor.forClass(FieldDO.class);
        when(courtDO.addField(fieldCaptor.capture())).thenReturn(courtDO);
        when(courtRepository.findById(123L)).thenReturn(Optional.of(courtDO));
        when(courtRepository.save(courtDO)).thenReturn(courtDO);

        Court response = mock(Court.class);
        when(courtDOToResponseConverter.convert(courtDO)).thenReturn(response);
        assertEquals(response, courtAndFieldService.addFieldToCourt("123", fieldRequest));
        List<FieldDO> fieldValue = fieldCaptor.getAllValues();
        assertEquals("testName1", fieldValue.get(0).getFieldName());
        assertEquals("testType1", fieldValue.get(0).getFieldType());
        assertEquals("testName2", fieldValue.get(1).getFieldName());
        assertEquals("testType2", fieldValue.get(1).getFieldType());
        assertEquals("testName3", fieldValue.get(2).getFieldName());
        assertEquals("testType3", fieldValue.get(2).getFieldType());
        assertEquals(Arrays.asList("1", "2"), fieldValue.get(2).getSubFieldIds());
    }


}
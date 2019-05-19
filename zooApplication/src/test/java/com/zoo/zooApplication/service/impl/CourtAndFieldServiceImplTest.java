package com.zoo.zooApplication.service.impl;

import com.zoo.zooApplication.converter.CourtDOToResponseConverter;
import com.zoo.zooApplication.dao.model.CourtDO;
import com.zoo.zooApplication.dao.model.FieldDO;
import com.zoo.zooApplication.dao.repository.CourtRepository;
import com.zoo.zooApplication.dao.repository.FieldRepository;
import com.zoo.zooApplication.request.CreateFieldRequest;
import com.zoo.zooApplication.response.Court;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.constraints.NotNull;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        CreateFieldRequest request = new CreateFieldRequest();
        request.setFieldName("testName");
        request.setFieldType("testType");

        CourtDO courtDO = mock(CourtDO.class);
        ArgumentCaptor<FieldDO> fieldCaptor = ArgumentCaptor.forClass(FieldDO.class);
        when(courtDO.addField(fieldCaptor.capture())).thenReturn(courtDO);
        when(courtRepository.findById(123L)).thenReturn(Optional.of(courtDO));
        when(courtRepository.save(courtDO)).thenReturn(courtDO);

        Court response = mock(Court.class);
        when(courtDOToResponseConverter.convert(courtDO)).thenReturn(response);
        assertEquals(response, courtAndFieldService.addFieldToCourt("123", request));
        FieldDO fieldValue = fieldCaptor.getValue();
        assertEquals("testName", fieldValue.getFieldName());
        assertEquals("testType", fieldValue.getFieldType());
    }


}
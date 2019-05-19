package com.zoo.zooApplication.converter;

import com.zoo.zooApplication.dao.model.FieldBookingDO;
import com.zoo.zooApplication.dao.model.FieldDO;
import com.zoo.zooApplication.response.Field;
import com.zoo.zooApplication.response.FieldBooking;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FieldDOToResponseConverterTest {

    private FieldDOToResponseConverter testConverter;

    private FieldDO fieldDO;

    @Before
    public void setUp() {
        testConverter = new FieldDOToResponseConverter();
        fieldDO = mock(FieldDO.class);
    }

    @Test(expected = NullPointerException.class)
    public void testConvertWithNull() {
        testConverter.convert(null);
    }

    @Test
    public void testConvertWithFieldId() {
        when(fieldDO.getId()).thenReturn(Long.valueOf(123));
        Field field = testConverter.convert(fieldDO);
        assertEquals(123l, field.getId());
    }

    @Test
    public void testConvertWithFieldName() {
        when(fieldDO.getFieldName()).thenReturn("name");
        Field field = testConverter.convert(fieldDO);
        assertEquals("name", field.getFieldName());
    }

    @Test
    public void testConvertWithFieldType() {
        when(fieldDO.getFieldType()).thenReturn("type");
        Field field = testConverter.convert(fieldDO);
        assertEquals("type", field.getFieldType());
    }

}
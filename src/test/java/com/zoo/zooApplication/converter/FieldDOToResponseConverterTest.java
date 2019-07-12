package com.zoo.zooApplication.converter;

import com.zoo.zooApplication.dao.model.FieldDO;
import com.zoo.zooApplication.response.Field;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
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
        when(fieldDO.getName()).thenReturn("name");
        Field field = testConverter.convert(fieldDO);
        assertEquals("name", field.getName());
    }

    @Test
    public void testConvertWithFieldTypeId() {
        when(fieldDO.getFieldTypeId()).thenReturn(Long.valueOf(123));
        Field field = testConverter.convert(fieldDO);
        assertEquals(123l, field.getFieldTypeId());
    }

    @Test
    public void testConvertWithSubFieldIds() {
        when(fieldDO.getSubFieldIds()).thenReturn(Arrays.asList(123L, 456L));
        Field field = testConverter.convert(fieldDO);
        assertEquals(Arrays.asList(123L, 456L), field.getSubFieldIds());
    }

}
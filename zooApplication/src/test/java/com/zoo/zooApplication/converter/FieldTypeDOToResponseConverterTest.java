package com.zoo.zooApplication.converter;

import com.zoo.zooApplication.dao.model.FieldTypeDO;
import com.zoo.zooApplication.response.FieldType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FieldTypeDOToResponseConverterTest {

    private FieldTypeDOToResponseConverter testConverter;

    private PriceChartDOToResponseConverter priceChartDOToResponseConverter;

    private FieldTypeDO mockDO;

    @Before
    public void setUp() {
        priceChartDOToResponseConverter = mock(PriceChartDOToResponseConverter.class);
        testConverter = new FieldTypeDOToResponseConverter(priceChartDOToResponseConverter);
        mockDO = mock(FieldTypeDO.class);
    }

    @Test(expected = NullPointerException.class)
    public void testConvertWithNull() {
        testConverter.convert(null);
    }

    @Test
    public void testConvertVerifyId() {
        when(mockDO.getId()).thenReturn(123L);
        FieldType fieldType = testConverter.convert(mockDO);
        assertEquals(123L, fieldType.getId());
    }

    @Test
    public void testConvertVerifyName() {
        when(mockDO.getName()).thenReturn("test");
        FieldType fieldType = testConverter.convert(mockDO);
        assertEquals("test", fieldType.getName());
    }

}
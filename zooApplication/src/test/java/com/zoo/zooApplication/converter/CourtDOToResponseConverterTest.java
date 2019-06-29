package com.zoo.zooApplication.converter;

import com.zoo.zooApplication.dao.model.CourtDO;
import com.zoo.zooApplication.dao.model.FieldDO;
import com.zoo.zooApplication.dao.model.PriceChartDO;
import com.zoo.zooApplication.response.Court;
import com.zoo.zooApplication.response.Field;
import com.zoo.zooApplication.response.PriceChart;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CourtDOToResponseConverterTest {

    private CourtDOToResponseConverter testConverter;

    private CourtDO courtDO;

    private FieldDOToResponseConverter fieldDOToResponseConverter;

    private PriceChartDOToResponseConverter priceChartDOToResponseConverter;

    @Before
    public void setUp() {
        fieldDOToResponseConverter = mock(FieldDOToResponseConverter.class);
        priceChartDOToResponseConverter = mock(PriceChartDOToResponseConverter.class);
        testConverter = new CourtDOToResponseConverter(fieldDOToResponseConverter,priceChartDOToResponseConverter);
        courtDO = mock(CourtDO.class);
    }

    @Test(expected = NullPointerException.class)
    public void testConvertWithNull() {
        testConverter.convert(null);
    }

    @Test
    public void testConvertWithCourtId() {
        when(courtDO.getId()).thenReturn(Long.valueOf(123));
        Court court = testConverter.convert(courtDO);
        assertEquals(123l, court.getId());
    }

    @Test
    public void testConvertWithCourtName() {
        when(courtDO.getCourtName()).thenReturn("name");
        Court court = testConverter.convert(courtDO);
        assertEquals("name", court.getCourtName());
    }

    @Test
    public void testConvertWithCourtAddress() {
        when(courtDO.getCourtAddress()).thenReturn("123 Test");
        Court court = testConverter.convert(courtDO);
        assertEquals("123 Test", court.getCourtAddress());
    }

    @Test
    public void testConvertWithCourtPhone() {
        when(courtDO.getCourtPhone()).thenReturn("123456");
        Court court = testConverter.convert(courtDO);
        assertEquals("123456", court.getCourtPhone());
    }

    @Test
    public void testConvertWithEmptyField() {
        when(courtDO.getFields()).thenReturn(new ArrayList<>());
        Court court = testConverter.convert(courtDO);
        assertTrue(court.getFields().isEmpty());
    }

    @Test
    public void testConvertWithSomeFields() {
        List<FieldDO> mockList = new ArrayList<>();
        mockList.add(mock(FieldDO.class));
        mockList.add(mock(FieldDO.class));

        List<Field> expectList = new ArrayList<>();
        expectList.add(mock(Field.class));
        expectList.add(mock(Field.class));

        when(fieldDOToResponseConverter.convert(mockList.get(0))).thenReturn(expectList.get(0));
        when(fieldDOToResponseConverter.convert(mockList.get(1))).thenReturn(expectList.get(1));

        when(courtDO.getFields()).thenReturn(mockList);
        Court court = testConverter.convert(courtDO);
        assertEquals(expectList, court.getFields());
    }

    @Test
    public void testConvertWithEmptyPriceChart(){
        when(courtDO.getPriceCharts()).thenReturn(new ArrayList<>());
        Court court = testConverter.convert(courtDO);
        assertTrue(court.getPriceCharts().isEmpty());
    }

    @Test
    public void testConvertWithPriceCharts(){
        List<PriceChartDO> mockList = new ArrayList<>();
        mockList.add(mock(PriceChartDO.class));
        mockList.add(mock(PriceChartDO.class));

        List<PriceChart> expectList = new ArrayList<>();
        expectList.add(mock(PriceChart.class));
        expectList.add(mock(PriceChart.class));

        when(priceChartDOToResponseConverter.convert(mockList.get(0))).thenReturn(expectList.get(0));
        when(priceChartDOToResponseConverter.convert(mockList.get(1))).thenReturn(expectList.get(1));
        when(courtDO.getPriceCharts()).thenReturn(mockList);

        Court court = testConverter.convert(courtDO);
        assertEquals(expectList, court.getPriceCharts());
    }
}
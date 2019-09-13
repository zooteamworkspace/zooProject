package com.zoo.zooApplication.converter;

import com.zoo.zooApplication.dao.model.PriceChartDO;
import com.zoo.zooApplication.response.Field;
import com.zoo.zooApplication.response.PriceChart;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceChartDOToResponseConverterTest {

    private PriceChartDOToResponseConverter testConverter;

    private PriceChartDO priceChartDO;

    @Before
    public void setUp(){
        testConverter = new PriceChartDOToResponseConverter();
        priceChartDO = mock(PriceChartDO.class);
    }

    @Test(expected = NullPointerException.class)
    public void testConverterWithNull(){
        testConverter.convert(null);
    }

//    TODO
//    @Test
//    public void testConvertWithFieldType(){
//        when(priceChartDO.getFieldType()).thenReturn("5");
//        PriceChart priceChart = testConverter.convert(priceChartDO);
//        assertEquals("5",priceChart.getFieldType());
//    }
//
//    @Test
//    public void testConvertWithPriceType(){
//        when(priceChartDO.getPriceType()).thenReturn("Normal");
//        PriceChart priceChart = testConverter.convert(priceChartDO);
//        assertEquals("Normal",priceChart.getPriceType());
//    }

//    @Test
//    public void testConvertWithTimeStart(){
//        when(priceChartDO.getTimeStart()).thenReturn(LocalTime.of(1,1,1));
//        PriceChart priceChart = testConverter.convert(priceChartDO);
//        assertEquals("01:01:01",priceChart.getTimeStart());
//    }
//
//    @Test
//    public void testConvertWithTimeEnd(){
//        when(priceChartDO.getTimeEnd()).thenReturn(LocalTime.of(1,1,1));
//        PriceChart priceChart = testConverter.convert(priceChartDO);
//        assertEquals("01:01:01",priceChart.getTimeEnd());
//    }
}

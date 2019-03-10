package com.zoo.zooApplication.util;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

public class DOTimestampConverterTest {

    @Test
    public void testToDatabaseAsMilliseconds() {
        LocalDateTime localDateTime = ZonedDateTime
                .of(LocalDateTime.of(2019, Month.JANUARY, 1, 10, 20, 30, 412000000), ZoneId.of("UTC"))
                .toLocalDateTime();
        DOTimestampConverter attrConverter = new DOTimestampConverter();
        assertEquals(Long.valueOf(1546338030412l), attrConverter.convertToDatabaseColumn(localDateTime));
    }

    @Test
    public void testFromDBToLocalDateTime() {
        DOTimestampConverter attrConverter = new DOTimestampConverter();
        LocalDateTime localDateTime = attrConverter.convertToEntityAttribute(1551681185000l);
        assertEquals(2019, localDateTime.getYear());
        assertEquals(Month.MARCH, localDateTime.getMonth());
        assertEquals(4, localDateTime.getDayOfMonth());
        assertEquals(6, localDateTime.getHour());
        assertEquals(33, localDateTime.getMinute());
        assertEquals(5, localDateTime.getSecond());
    }

}
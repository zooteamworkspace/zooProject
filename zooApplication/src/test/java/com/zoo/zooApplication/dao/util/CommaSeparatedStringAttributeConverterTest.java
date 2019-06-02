package com.zoo.zooApplication.dao.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CommaSeparatedStringAttributeConverterTest {

    @Test
    public void testToDatabaseColumn() {
        CommaSeparatedStringAttributeConverter converter = new CommaSeparatedStringAttributeConverter();
        String result = converter.convertToDatabaseColumn(Arrays.asList("test1", "test2"));
        assertEquals("test1,test2", result);
    }

    @Test
    public void testToDatabaseColumnEmpty() {
        CommaSeparatedStringAttributeConverter converter = new CommaSeparatedStringAttributeConverter();
        String result = converter.convertToDatabaseColumn(new ArrayList<>());
        assertNull(result);
    }

    @Test
    public void testToEntityAttribute() {
        CommaSeparatedStringAttributeConverter converter = new CommaSeparatedStringAttributeConverter();
        List<String> result = converter.convertToEntityAttribute("test1,test2");
        assertEquals(Arrays.asList("test1", "test2"), result);
    }

    @Test
    public void testToEntityAttributeNull() {
        CommaSeparatedStringAttributeConverter converter = new CommaSeparatedStringAttributeConverter();
        List<String> result = converter.convertToEntityAttribute(null);
        assertTrue(result.isEmpty());
    }
}
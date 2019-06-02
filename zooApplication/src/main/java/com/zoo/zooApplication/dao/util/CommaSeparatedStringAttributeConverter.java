package com.zoo.zooApplication.dao.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter
public class CommaSeparatedStringAttributeConverter implements AttributeConverter<List<String>, String> {
    private static final String COMMA = ",";

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (CollectionUtils.isNotEmpty(attribute)) {
            return StringUtils.join(attribute, COMMA);
        } else {
            return null;
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (StringUtils.isNotBlank(dbData)) {
            return Arrays.asList(StringUtils.split(dbData, COMMA));
        } else {
            return new ArrayList<>();
        }
    }
}

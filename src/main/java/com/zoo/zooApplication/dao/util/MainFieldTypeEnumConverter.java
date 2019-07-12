package com.zoo.zooApplication.dao.util;

import com.zoo.zooApplication.type.MainFieldTypeEnum;

import javax.persistence.AttributeConverter;

public class MainFieldTypeEnumConverter implements AttributeConverter<MainFieldTypeEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MainFieldTypeEnum attribute) {
        return attribute != null ? attribute.getId() : - 1;
    }

    @Override
    public MainFieldTypeEnum convertToEntityAttribute(Integer dbData) {
        if (dbData != null) {
            return MainFieldTypeEnum.getFromId(dbData);
        }
        return null;
    }
}

package com.zoo.zooApplication.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Objects;

@Converter
public class DOTimestampConverter implements AttributeConverter<LocalDateTime, Long> {

    @Override
    public Long convertToDatabaseColumn(LocalDateTime localDateTime) {
        Objects.requireNonNull(localDateTime);
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Long milliseconds) {
        Objects.requireNonNull(milliseconds);
        return Instant.ofEpochMilli(milliseconds).atZone(ZoneId.of("UTC")).toLocalDateTime();
    }
}

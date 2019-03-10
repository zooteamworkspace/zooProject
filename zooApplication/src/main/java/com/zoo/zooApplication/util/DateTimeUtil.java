package com.zoo.zooApplication.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeUtil {



    public static ZonedDateTime parseISO8601Format(String stringISO8601) {
        if (stringISO8601 == null) {
            return null;
        }
        return Instant.parse(stringISO8601).atZone(ZoneOffset.UTC.normalized()).withZoneSameInstant(ZoneId.of("UTC"));
    }
}

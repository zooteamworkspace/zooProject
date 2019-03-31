package com.zoo.bookingService.converter;

import com.zoo.bookingService.dao.model.FieldBookingDO;
import com.zoo.bookingService.response.FieldBooking;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Component
public class FieldBookingDOToResponseConverter {
    public FieldBooking convert(@NotNull final FieldBookingDO fieldBookingDO) {
        Objects.requireNonNull(fieldBookingDO);

        return FieldBooking
                .builder()
                .id(fieldBookingDO.getId())
                .fieldId(fieldBookingDO.getFieldId())
                .courtId(fieldBookingDO.getCourtId())
                .build();
    }
}

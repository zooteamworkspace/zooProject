package com.zoo.bookingService.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FieldBooking {

    private long id;

    private long courtId;

    private long fieldId;


}

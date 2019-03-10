package com.zoo.zooApplication.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.persistence.Column;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@ApiModel(value = "CreateBookingRequest", description = "The request to create a booking")
public class CreateBookingRequest {

    @ApiModelProperty(value = "The unique identifier of the field associate with the booking", required = true)
    private Long fieldId;

    @ApiModelProperty(value = "Time for the booking to start in format YYYY-MM-ddTHH:mm:ssZ (ISO-8601)", required = true)
    private String timeIn;

    @ApiModelProperty(value = "Duration in minute of the booking, must be increment of 30min", required = true)
    private int duration;

    @ApiModelProperty(value = "Name for booker", required = true)
    private String bookerName;

    @ApiModelProperty(value = "Email of the booker", required = true)
    private String bookerEmail;

    @ApiModelProperty(value = "Phone of the booker")
    private String bookerPhone;

    // TODO: support multiple currencies later
    @ApiModelProperty(value = "Price amount of booking. Default: VND")
    private Double priceAmount;
}

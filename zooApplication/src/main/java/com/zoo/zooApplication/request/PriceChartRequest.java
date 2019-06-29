package com.zoo.zooApplication.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ApiModel(value = "PriceChartRequest", description = "The price chart info to add to court")
public class PriceChartRequest {
    @ApiModelProperty(value = "The field type")
    private Long fieldTypeId;

    @ApiModelProperty(value = "Price amount of booking. Default: VND")
    private Double priceAmount;

    @ApiModelProperty(value = "Starting time of the price in format HH:mm:ssZ (ISO-8601)", required = true)
    private String timeStart;

    @ApiModelProperty(value = "Starting time of the price in format HH:mm:ssZ (ISO-8601)", required = true)
    private String timeEnd;
}

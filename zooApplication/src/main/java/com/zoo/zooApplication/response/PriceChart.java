package com.zoo.zooApplication.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Builder
@ApiModel(value = "PriceChart", description = "The price chart decided by the court owner")
public class PriceChart {

    @ApiModelProperty(value = "The unique identifier of the price chart", readOnly = true)
    private long id;

    @ApiModelProperty(value = "The field type", readOnly = true)
    private long fieldTypeId;

    @ApiModelProperty(value = "The price amount", readOnly = true)
    private Double priceAmount;

    @ApiModelProperty(value = "The price type of selected price", readOnly = true)
    private int day;

    @ApiModelProperty(value = "The starting time of selected price", readOnly = true)
    private String timeStart;

    @ApiModelProperty(value = "The ending time of selected price", readOnly = true)
    private String timeEnd;
}

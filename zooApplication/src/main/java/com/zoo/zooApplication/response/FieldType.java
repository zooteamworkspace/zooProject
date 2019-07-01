package com.zoo.zooApplication.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Builder
@ApiModel(value = "FieldType", description = "The type of field price decided by the court owner")
public class FieldType {

    @ApiModelProperty(value = "The unique identifier of the field type", readOnly = true)
    private long id;

    @ApiModelProperty(value = "The main field type - 5 7 11", readOnly = true)
    private int mainType;

    @ApiModelProperty(value = "The court ID matchs with this owner", readOnly = true)
    private long courtId;

    @ApiModelProperty(value = "The common name for that type", readOnly = true)
    private String fieldTypeName;

    @ApiModelProperty(value = "All the price charts belong to this type", readOnly = true)
    private List<PriceChart> priceCharts;
}

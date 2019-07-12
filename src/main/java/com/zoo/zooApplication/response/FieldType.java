package com.zoo.zooApplication.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zoo.zooApplication.type.MainFieldTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Builder
@ApiModel(value = "FieldType", description = "Represent a field type of a court decided by court owner")
public class FieldType {

    @ApiModelProperty(value = "The unique identifier of the field type", readOnly = true)
    private long id;

    @ApiModelProperty(value = "The court ID matchs with this owner", readOnly = true)
    private long courtId;

    @ApiModelProperty(value = "The name given for the field type", readOnly = true)
    private String name;

    @ApiModelProperty(value = "The enum identify the capacity type of the field", readOnly = true)
    private MainFieldTypeEnum mainFieldType;

    @ApiModelProperty(value = "All the price charts belong to this type", readOnly = true)
    private List<PriceChart> priceCharts;

}
package com.zoo.zooApplication.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ApiModel(value = "FieldTypeRequest", description = "The specific types of all available fields")
public class FieldTypeRequest {
    @ApiModelProperty(value = "The field type")
    private Long courtId;

    @ApiModelProperty(value = "The main type of the field - 5,7,11")
    private int mainType;

    @ApiModelProperty(value = "The name of field's type")
    private String fieldTypeName;
}

package com.zoo.zooApplication.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ApiModel(value = "CreateFieldRequest", description = "The request to add a field to a court")
public class CreateFieldRequest {
    @ApiModelProperty(value = "The field name")
    private String fieldName;

    @ApiModelProperty(value = "The field type")
    private String fieldType;


}

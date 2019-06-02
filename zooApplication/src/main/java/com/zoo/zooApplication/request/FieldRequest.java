package com.zoo.zooApplication.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ApiModel(value = "FieldRequest", description = "The field info to add to court")
public class FieldRequest {
    @ApiModelProperty(value = "The field name")
    private String fieldName;

    @ApiModelProperty(value = "The field type")
    private String fieldType;

    @ApiModelProperty(value = "The list of field ids that make up this field")
    private List<String> subFieldIds;
}

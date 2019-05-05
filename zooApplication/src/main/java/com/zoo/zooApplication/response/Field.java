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
@ApiModel(value = "Field", description = "Represent a field entity")
public class Field {

    @ApiModelProperty(value = "The unique identifier of the court", readOnly = true)
    private long id;

    @ApiModelProperty(value = "The field name if available", readOnly = true)
    private String fieldName;

    @ApiModelProperty(value = "The field type", readOnly = true)
    private String fieldType;


}

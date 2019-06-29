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
@ApiModel(value = "Court", description = "Represent a court entity")
public class Court {

    @ApiModelProperty(value = "The unique identifier of the court", readOnly = true)
    private long id;

    @ApiModelProperty(value = "The court name which is also the business name", readOnly = true)
    private String courtName;

    @ApiModelProperty(value = "The address of the court", readOnly = true)
    private String courtAddress;

    @ApiModelProperty(value = "The phone number of the court", readOnly = true)
    private String courtPhone;

    @ApiModelProperty(value = "The all the field belong to this court", readOnly = true)
    private List<Field> fields;

    @ApiModelProperty(value = "All the price charts belong to this court", readOnly = true)
    private List<FieldType> fieldTypes;
}

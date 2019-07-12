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
@ApiModel(value = "Field", description = "Represent a field entity")
public class Field {

    @ApiModelProperty(value = "The unique identifier of the court", readOnly = true)
    private long id;

    @ApiModelProperty(value = "The field name if available", readOnly = true)
    private String name;

    @ApiModelProperty(value = "The field type this field belong to", readOnly = true)
    private long fieldTypeId;

    @ApiModelProperty(value = "The list of field id that combine to this field, if this list is present mean that this field is not a unit field ", readOnly = true)
    private List<Long> subFieldIds;

}

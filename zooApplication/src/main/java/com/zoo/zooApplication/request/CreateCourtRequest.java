package com.zoo.zooApplication.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ApiModel(value = "CreateCourtRequest", description = "The request to create a court")
public class CreateCourtRequest {

    @ApiModelProperty(value = "Business name of the court")
    private String courtName;

    @ApiModelProperty(value = "Business address of the court")
    private String courtAddress;

    @ApiModelProperty(value = "Business phone number of the court")
    private String courtPhone;

}

package com.zoo.zooApplication.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Builder
@Getter
@Setter
public class SearchFieldBookingRequest {

    @ApiModelProperty(value = "The unique identifier of the requested searching field ")
    private String fieldId;

    @ApiModelProperty(value = "The number of records returns per page ")
    private int limit;

    @ApiModelProperty(value = "The index of starting page ")
    private int offset;

    public Long getFieldId(){
        return NumberUtils.toLong(fieldId);
    }

    public Pageable getPageable(){
        return PageRequest.of(offset, limit);
    }
}

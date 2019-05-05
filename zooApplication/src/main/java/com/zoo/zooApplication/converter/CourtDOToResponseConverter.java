package com.zoo.zooApplication.converter;

import com.zoo.zooApplication.dao.model.CourtDO;
import com.zoo.zooApplication.response.Court;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@Component
public class CourtDOToResponseConverter {

    private FieldDOToResponseConverter fieldDOToResponseConverter;

    @Inject
    public CourtDOToResponseConverter(FieldDOToResponseConverter fieldDOToResponseConverter) {
        this.fieldDOToResponseConverter = fieldDOToResponseConverter;
    }

    public Court convert(@NotNull final CourtDO court) {
        return null;
    }
}

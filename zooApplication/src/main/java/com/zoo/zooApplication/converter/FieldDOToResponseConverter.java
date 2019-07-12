package com.zoo.zooApplication.converter;

import com.zoo.zooApplication.dao.model.FieldDO;
import com.zoo.zooApplication.response.Field;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Component
public class FieldDOToResponseConverter {
    public Field convert(@NotNull final FieldDO fieldDO) {
        Objects.requireNonNull(fieldDO);

        return Field
                .builder()
                .id(fieldDO.getId())
                .name(fieldDO.getName())
                .fieldTypeId(fieldDO.getFieldTypeId())
                .subFieldIds(fieldDO.getSubFieldIds())
                .build();
    }
}

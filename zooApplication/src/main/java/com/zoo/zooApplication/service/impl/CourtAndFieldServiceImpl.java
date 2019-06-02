package com.zoo.zooApplication.service.impl;

import com.zoo.zooApplication.converter.CourtDOToResponseConverter;
import com.zoo.zooApplication.dao.model.CourtDO;
import com.zoo.zooApplication.dao.model.FieldDO;
import com.zoo.zooApplication.dao.repository.CourtRepository;
import com.zoo.zooApplication.dao.repository.FieldRepository;
import com.zoo.zooApplication.request.CreateCourtRequest;
import com.zoo.zooApplication.request.CreateFieldRequest;
import com.zoo.zooApplication.request.FieldRequest;
import com.zoo.zooApplication.response.Court;
import com.zoo.zooApplication.service.CourtAndFieldService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class CourtAndFieldServiceImpl implements CourtAndFieldService {

    // NOTE: ideally the design is fit for nosql db but initially use sql as prototype but it make good sense for court and field to be belong to a same service
    private CourtRepository courtRepository;

    private FieldRepository fieldRepository;

    private CourtDOToResponseConverter courtDOToResponseConverter;

    @Inject
    public CourtAndFieldServiceImpl(CourtRepository courtRepository, FieldRepository fieldRepository, CourtDOToResponseConverter courtDOToResponseConverter) {
        this.courtRepository = courtRepository;
        this.fieldRepository = fieldRepository;
        this.courtDOToResponseConverter = courtDOToResponseConverter;
    }

    @Override
    public Court createCourt(CreateCourtRequest createCourtRequest) {
        CourtDO courtDO = CourtDO.builder()
                .courtName(createCourtRequest.getCourtName())
                .courtAddress(createCourtRequest.getCourtAddress())
                .courtPhone(createCourtRequest.getCourtPhone())
                .build();

        Court court = courtDOToResponseConverter.convert(courtRepository.save(courtDO));
        return court;
    }

    @Override
    public Court findCourtById(String courtId) {
        Optional<CourtDO> court = courtRepository.findById(NumberUtils.toLong(courtId));
        return court
                .map(courtDOToResponseConverter::convert)
                .orElse(null);
    }

    @Override
    public Court findCourtByFieldId(String fieldId) {
        Optional<FieldDO> field = fieldRepository.findById(NumberUtils.toLong(fieldId));
        return field
                .map(fieldDO -> fieldDO.getCourt())
                .map(courtDOToResponseConverter::convert)
                .orElse(null);
    }

    @Override
    public Court addFieldToCourt(String courtId, CreateFieldRequest createFieldRequest) {
        Optional<CourtDO> court = courtRepository.findById(NumberUtils.toLong(courtId));

        return court
                .map(courtDO -> addFieldDO(courtDO, createFieldRequest.getFieldRequests()))
                .map(courtRepository::save)
                .map(courtDOToResponseConverter::convert)
                .orElse(null);

    }

    private CourtDO addFieldDO(CourtDO courtDO, List<FieldRequest> fieldRequests) {
        if (CollectionUtils.isNotEmpty(fieldRequests)) {
            fieldRequests
                    .stream()
                    .map(request -> FieldDO
                            .builder()
                            .fieldName(request.getFieldName())
                            .fieldType(request.getFieldType())
                            .subFieldIds(request.getSubFieldIds())
                            .build())
                    .forEach(fieldDO -> courtDO.addField(fieldDO));
        }
        return courtDO;
    }
}

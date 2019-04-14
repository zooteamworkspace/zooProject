package com.zoo.zooApplication.service.impl;

import com.zoo.zooApplication.dao.model.CourtDO;
import com.zoo.zooApplication.dao.model.FieldDO;
import com.zoo.zooApplication.dao.repository.CourtRepository;
import com.zoo.zooApplication.dao.repository.FieldRepository;
import com.zoo.zooApplication.response.Court;
import com.zoo.zooApplication.service.CourtAndFieldService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CourtAndFieldServiceImpl implements CourtAndFieldService {

    // NOTE: ideally the design is fit for nosql db but initially use sql as prototype but it make good sense for court and field to be belong to a same service
    private CourtRepository courtRepository;

    private FieldRepository fieldRepository;

    @Inject
    public CourtAndFieldServiceImpl(CourtRepository courtRepository, FieldRepository fieldRepository) {
        this.courtRepository = courtRepository;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public Court findCourtById(String courtId) {
        CourtDO test = courtRepository.findById(NumberUtils.toLong(courtId)).get();
        List<FieldDO> sets = test.getFields();
        return null;
    }
}

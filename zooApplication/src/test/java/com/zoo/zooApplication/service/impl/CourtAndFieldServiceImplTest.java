package com.zoo.zooApplication.service.impl;

import com.zoo.zooApplication.converter.CourtDOToResponseConverter;
import com.zoo.zooApplication.dao.repository.CourtRepository;
import com.zoo.zooApplication.dao.repository.FieldRepository;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class CourtAndFieldServiceImplTest {

    @Mock
    private CourtRepository courtRepository;

    @Mock
    private FieldRepository fieldRepository;

    @Mock
    private CourtDOToResponseConverter courtDOToResponseConverter;

    private CourtAndFieldServiceImpl courtAndFieldService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        courtAndFieldService = new CourtAndFieldServiceImpl(courtRepository, fieldRepository, courtDOToResponseConverter);
    }

}
package com.zoo.zooApplication.service;


import com.zoo.zooApplication.request.CreateCourtRequest;
import com.zoo.zooApplication.request.CreateFieldRequest;
import com.zoo.zooApplication.response.Court;

public interface CourtAndFieldService {
    Court createCourt(CreateCourtRequest createCourtRequest);
    Court findCourtById(String courtId);
    Court findCourtByFieldId(String fieldId);
    Court addFieldToCourt(String courtId, CreateFieldRequest createFieldRequest);
}

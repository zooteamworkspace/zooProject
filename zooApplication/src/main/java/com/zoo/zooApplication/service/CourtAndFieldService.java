package com.zoo.zooApplication.service;


import com.zoo.zooApplication.response.Court;

public interface CourtAndFieldService {
    Court findCourtById(String courtId);
}

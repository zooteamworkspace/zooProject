package com.zoo.zooApplication.dao.repository;

import com.zoo.zooApplication.dao.model.CourtDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends JpaRepository<CourtDO, Long> {
}

package com.zoo.zooApplication.dao.repository;

import com.zoo.zooApplication.dao.model.FieldTypeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldTypeRepository extends JpaRepository<FieldTypeDO, Long> {
}

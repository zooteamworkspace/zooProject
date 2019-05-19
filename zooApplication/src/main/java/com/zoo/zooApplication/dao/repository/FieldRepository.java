package com.zoo.zooApplication.dao.repository;

import com.zoo.zooApplication.dao.model.FieldDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<FieldDO, Long> {
}

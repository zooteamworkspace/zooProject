package com.zoo.bookingService.dao.repository;

import com.zoo.bookingService.dao.model.FieldBookingDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldBookingRepository extends JpaRepository<FieldBookingDO, Long> {
}

package com.zoo.zooApplication.dao.repository;

import com.zoo.zooApplication.dao.model.FieldBookingDO;
import com.zoo.zooApplication.response.FieldBooking;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldBookingRepository extends JpaRepository<FieldBookingDO, Long> {

    List<FieldBookingDO> findByBookerPhoneOrBookerEmailOrderByUpdatedAtDesc
            (String bookerEmail, String bookerPhone, Pageable pageable);
}

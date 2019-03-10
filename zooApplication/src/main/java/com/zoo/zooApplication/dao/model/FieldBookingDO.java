package com.zoo.zooApplication.dao.model;

import com.zoo.zooApplication.util.DOTimestampConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "field_bookings")
@Getter
@Builder
@AllArgsConstructor // require for @Builder to work correctly
@NoArgsConstructor // required for hibernate mapping
public class FieldBookingDO {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long courtId;

    @Column(nullable = false)
    private Long fieldId;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    private ZonedDateTime timeIn;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    private ZonedDateTime timeOut;

    @Column(nullable = false)
    private String status;

    @Column
    private Long bookerUserId;

    @Column
    private String bookerName;

    @Column
    private String bookerEmail;

    @Column
    private String bookerPhone;

    @Column
    private Double priceAmount;

    @Column
    private String currencyId;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}

package com.zoo.zooApplication.dao.model;

import com.zoo.zooApplication.util.DOTimestampConverter;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "field_bookings")
@Getter
public class FieldBookingDO {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    @NotNull
    private Long courtId;

    @Column
    @NotNull
    private Long fieldId;

    @Column
    @Convert(converter = DOTimestampConverter.class)
    @NotNull
    private LocalDateTime timeIn;

    @Column
    @Convert(converter = DOTimestampConverter.class)
    @NotNull
    private LocalDateTime timeOut;

    @Column
    @NotNull
    private Integer status;

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

    @Column
    @Convert(converter = DOTimestampConverter.class)
    @CreationTimestamp
    @NotNull
    private LocalDateTime createdAt;

    @Column
    @Convert(converter = DOTimestampConverter.class)
    @UpdateTimestamp
    @NotNull
    private LocalDateTime updatedAt;

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }
}

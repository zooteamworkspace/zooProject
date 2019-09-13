package com.zoo.zooApplication.dao.model;

import com.zoo.zooApplication.dao.util.DOTimestampConverter;
import com.zoo.zooApplication.type.DayOfWeekEnum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Entity
@Table(name="price_charts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@SelectBeforeUpdate(false)
public class PriceChartDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double priceAmount;

    @Column
    private String currencyId;

    @Column(nullable = false)
    private Integer timeStart;

    @Column(nullable = false)
    private Integer timeEnd;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    @ManyToOne(targetEntity = FieldTypeDO.class, fetch = FetchType.EAGER)
    @JoinColumn(name="field_type_id", updatable = false)
    private FieldTypeDO fieldType;

}

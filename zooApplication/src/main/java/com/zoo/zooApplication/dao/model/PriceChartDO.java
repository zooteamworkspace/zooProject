package com.zoo.zooApplication.dao.model;

import com.zoo.zooApplication.dao.util.DOTimestampConverter;
import com.zoo.zooApplication.util.EnumCollections.DayOfWeek;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
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
public class PriceChartDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false,columnDefinition = "day_of_week")
    private DayOfWeek day;

    @Column
    private Double priceAmount;

    @Column
    private String currencyId;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    private LocalTime timeStart;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    private LocalTime timeEnd;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    @ManyToOne(targetEntity = FieldTypeDO.class, fetch = FetchType.EAGER)
    @JoinColumn(name="field_type_id")
    private FieldTypeDO fieldType;
}

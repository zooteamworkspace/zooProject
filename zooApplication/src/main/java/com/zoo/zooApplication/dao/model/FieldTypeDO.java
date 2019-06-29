package com.zoo.zooApplication.dao.model;

import com.zoo.zooApplication.dao.util.DOTimestampConverter;
import com.zoo.zooApplication.util.EnumCollections.MainFieldType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="field_types")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldTypeDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false,columnDefinition = "main_field_type")
    private MainFieldType fieldType;

    @Column
    private String fieldTypeName;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    @ManyToOne(targetEntity = CourtDO.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "court_id")
    private CourtDO court;

    @OneToMany(targetEntity = PriceChartDO.class, fetch = FetchType.EAGER,
    cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fieldType")
    private final List<PriceChartDO> priceCharts = new ArrayList<>();

    public FieldTypeDO addPriceChart(PriceChartDO priceChartDO){
        priceCharts.add(priceChartDO);
        priceChartDO.setFieldType(this);
        return this;
    }
}

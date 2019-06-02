package com.zoo.zooApplication.dao.model;

import com.zoo.zooApplication.dao.util.DOTimestampConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courts")
@Getter
@Builder
@AllArgsConstructor // require for @Builder to work correctly
@NoArgsConstructor // required for hibernate mapping
public class CourtDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String courtName;

    @Column
    private String courtAddress;

    @Column
    private String courtPhone;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    @OneToMany(targetEntity = FieldDO.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "court")
    private final List<FieldDO> fields = new ArrayList<>();

    public CourtDO addField(FieldDO fieldDO) {
        fields.add(fieldDO);
        fieldDO.setCourt(this);
        return this;
    }


}

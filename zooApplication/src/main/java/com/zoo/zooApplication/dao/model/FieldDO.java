package com.zoo.zooApplication.dao.model;

import com.zoo.zooApplication.dao.util.IdListToStringAttributeConverter;
import com.zoo.zooApplication.dao.util.DOTimestampConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "fields")
@Getter
@Setter
@Builder
@AllArgsConstructor // require for @Builder to work correctly
@NoArgsConstructor // required for hibernate mapping
public class FieldDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String fieldType;

    @Column
    @Convert(converter = IdListToStringAttributeConverter.class)
    private List<Long> subFieldIds;

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

}

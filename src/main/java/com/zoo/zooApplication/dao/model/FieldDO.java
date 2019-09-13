package com.zoo.zooApplication.dao.model;

import com.zoo.zooApplication.dao.util.IdListToStringAttributeConverter;
import com.zoo.zooApplication.dao.util.DOTimestampConverter;
import com.zoo.zooApplication.dao.util.MainFieldTypeEnumConverter;
import com.zoo.zooApplication.type.MainFieldTypeEnum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
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
@DynamicUpdate
@SelectBeforeUpdate(false)
public class FieldDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // name is SQL keyword
    @Column(name = "field_name")
    private String name;

    @Column
    @Convert(converter = MainFieldTypeEnumConverter.class)
    private MainFieldTypeEnum mainFieldType;

    @Column
    private Long fieldTypeId;

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
    @JoinColumn(name = "court_id", updatable = false)
    private CourtDO court;

}

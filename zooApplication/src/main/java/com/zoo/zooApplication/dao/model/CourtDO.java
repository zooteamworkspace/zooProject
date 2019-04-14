package com.zoo.zooApplication.dao.model;

import com.zoo.zooApplication.util.DOTimestampConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
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
    private Long ownerId;

    @Column
    private String courtName;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @Column(nullable = false)
    @Convert(converter = DOTimestampConverter.class)
    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    // eager load
    // unidirectional from court to field only since when fetching court, more likely to view the field also
    @OneToMany(targetEntity = FieldDO.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "court_id")
    private List<FieldDO> fields;


}

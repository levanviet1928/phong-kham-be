package com.team2.his.entitis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
public class BaseEntity {
    @Column(
        name = "is_deleted"
    )
    private Boolean isDeleted = false;
//    @Column(
//        name = "created_by",
//        length = 255
//    )
//    @CreatedBy
//    private String createdBy;
//    @CreatedDate
//    @Column(
//        name = "created_time",
//        nullable = false
//    )
//    private LocalDateTime createdTime;
//    @Column(
//        name = "updated_by",
//        length = 255
//    )
//    @LastModifiedBy
//    private String updatedBy;
//    @LastModifiedDate
//    @Column(
//        name = "updated_time",
//        nullable = true
//    )
//    private LocalDateTime updatedTime;
//    @Transient
//    private String deletedBy;
//    @Transient
//    private LocalDateTime deletedTime;

}

package com.team2.his.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "service")
@SQLDelete(sql = "UPDATE service set is_deleted = 1")
@Where(clause = "is_deleted = false ")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ServiceEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID ServiceId;

    @Column(name = "service_code")
    private String ServiceCode;
    @Column(name = "service_name")
    private String  ServiceName;
    @Column(name = "price")
    private BigDecimal Price;

}
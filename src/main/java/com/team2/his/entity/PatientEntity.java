package com.team2.his.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "patient")
@SQLDelete(sql = "UPDATE patient set is_deleted = 1")
@Where(clause = "is_deleted = false ")
public class PatientEntity extends BaseEntity {
    @Id

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID PatientId;

    @Column(name = "patient_code")
    private String PatientCode;
    @Column(name = "patient_name")
    private String  PatientName;
    @Column(name = "age")
    private Integer Age;
    @Column(name = "gender")
    private String Gender;
    @Column(name = "phone")
    private Integer Phone;
    @Column(name = "address")
    private String Address;
}

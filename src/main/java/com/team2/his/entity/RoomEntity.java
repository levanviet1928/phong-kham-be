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
@Table(name = "room")
@SQLDelete(sql = "UPDATE room set is_deleted = 1")
@Where(clause = "is_deleted = false ")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public class RoomEntity  extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
        private UUID RoomId;

        @Column(name = "room_code")
        private String RoomCode;
        @Column(name = "room_name")
        private String  RoomName;

    }

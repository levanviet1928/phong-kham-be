package com.team2.his.repostiris;

import com.team2.his.entity.RoomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
    @Query("SELECT A " +
            "FROM RoomEntity A " +
            "WHERE  A.isDeleted = false")
    Page<RoomEntity> findAll(Pageable pageable);
}

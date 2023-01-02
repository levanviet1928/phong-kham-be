package com.team2.his.repostiris;

import com.team2.his.entity.ServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UltrasoundServiceRepository extends JpaRepository<ServiceEntity, UUID> {
    @Query("SELECT E " +
            "FROM ServiceEntity E " +
            "WHERE  E.isDeleted = false")
    Page<ServiceEntity> findAll(Pageable pageable);
}

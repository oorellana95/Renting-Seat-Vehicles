package com.mybackend.seat.application.domain.repositories;


import com.mybackend.seat.application.domain.entities.VehiclesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//--- Repository Interface -------------------------------------------
@Repository
public interface VehiclesRepository extends JpaRepository<VehiclesEntity, Long> {
    @Query(value = "select e from VehiclesEntity e where (e.pricePerDay > :minPrice) AND (e.pricePerDay < :maxPrice) AND (e.mobilityType.id = :idMobilityType)")
    List<VehiclesEntity> findApplyingFilter(@Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice, @Param("idMobilityType") long idMobilityType);
}

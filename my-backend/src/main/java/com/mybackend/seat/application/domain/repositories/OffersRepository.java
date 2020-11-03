package com.mybackend.seat.application.domain.repositories;

import com.mybackend.seat.application.domain.entities.OffersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//--- Repository Interface -------------------------------------------
@Repository
public interface OffersRepository extends JpaRepository<OffersEntity, Long> {
}

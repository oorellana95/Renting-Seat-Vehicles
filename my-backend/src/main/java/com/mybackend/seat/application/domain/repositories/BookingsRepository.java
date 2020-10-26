package com.mybackend.seat.application.domain.repositories;

import com.mybackend.seat.application.domain.entities.BookingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//--- Repository Interface -------------------------------------------
@Repository
public interface BookingsRepository extends JpaRepository<BookingsEntity, Long> {
}

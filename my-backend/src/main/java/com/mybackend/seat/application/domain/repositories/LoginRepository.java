package com.mybackend.seat.application.domain.repositories;

import com.mybackend.seat.application.domain.entities.LoginsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//--- Repository Interface -------------------------------------------
@Repository
public interface LoginRepository extends JpaRepository<LoginsEntity, Long> {
    @Query(value = "select e from LoginsEntity e where (e.username like :username)")
    LoginsEntity findLoginByUsername(@Param("username") String username);
}


package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.RestaurantEntity;

import java.math.BigDecimal;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE RestaurantEntity r SET r.status = :status WHERE r.restId = :id")
    void updateStatus(@Param("id") Long id, @Param("status") String status);

}

package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.CourierEntity;


@Repository
public interface CourierRepository extends JpaRepository<CourierEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE CourierEntity r SET r.status = :status WHERE r.CourierId = :id")
    void updateStatusById(@Param("id") Long id, @Param("status") String status);
}

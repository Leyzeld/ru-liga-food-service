package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.CourierEntity;
import ru.liga.model.OrderEntity;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("SELECT o FROM OrderEntity o WHERE o.status = :status")
    List<OrderEntity> findByStatus(@Param("status") String status);

    @Modifying
    @Transactional
    @Query("UPDATE OrderEntity o SET o.courierEntity = :courier WHERE o.id = :id")
    void updateCourierEntity(@Param("id") Long id, @Param("courier") CourierEntity courier);
}

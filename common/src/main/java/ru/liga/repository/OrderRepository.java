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
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    @Query("SELECT o FROM OrderEntity o WHERE o.status = :status")
    List<OrderEntity> findByStatus(@Param("status") String status);

    @Modifying
    @Transactional
    @Query("UPDATE OrderEntity o SET o.courierEntity = :courier WHERE o.id = :id")
    void updateCourierEntity(@Param("id") UUID id, @Param("courier") CourierEntity courier);

    @Modifying
    @Transactional
    @Query("UPDATE OrderEntity o SET o.status = :status WHERE o.id = :id")
    void updateStatus(@Param("id") UUID id, @Param("status") String status);
}

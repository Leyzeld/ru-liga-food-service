package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.OrderItemEntity;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
    @Transactional
    @Modifying
    @Query("SELECT i FROM OrderItemEntity i WHERE i.orderId.id = :orderId")
    List<OrderItemEntity> findByOrderId(@Param("orderId") Long orderId);
}

package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.RestaurantMenuItemEntity;
import java.math.BigDecimal;

@Repository
public interface RestaurantMenuItemsRepository extends JpaRepository<RestaurantMenuItemEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE RestaurantMenuItemEntity r SET r.price = :price WHERE r.restMenuItemId = :id")
    void updatePrice(@Param("id") Long id, @Param("price") BigDecimal price);
}

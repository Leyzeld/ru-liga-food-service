package ru.liga.repository.api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.model.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {


}

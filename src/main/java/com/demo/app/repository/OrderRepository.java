package com.demo.app.repository;

import com.demo.app.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByCreateDateGreaterThanOrderByCreateDateDesc(Instant createDate);

}

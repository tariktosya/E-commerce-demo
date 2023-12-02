package com.demo.app.repository;

import com.demo.app.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> getAllByNameLike(String name);
    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.orderList is empty")
    List<CustomerEntity> getCustomerByOrderListIsNull();
}

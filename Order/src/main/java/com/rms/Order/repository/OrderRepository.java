package com.rms.Order.repository;


import com.rms.Order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface OrderRepository extends JpaRepository<OrderDetail, Long> {

    Optional<OrderDetail> findByOrderRequestid(String id);
    Optional<OrderDetail> findByOrderHandlerid(String id);
}

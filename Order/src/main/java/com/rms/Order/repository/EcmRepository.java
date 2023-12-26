package com.rms.Order.repository;


import com.rms.Order.entity.Ecm;
import com.rms.Order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface EcmRepository extends JpaRepository<Ecm, Long> {
    Optional<Ecm> findByOrderRequestid(String id);

}

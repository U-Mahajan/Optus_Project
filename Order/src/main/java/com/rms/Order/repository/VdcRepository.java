package com.rms.Order.repository;


import com.rms.Order.entity.OrderDetail;
import com.rms.Order.entity.Vdc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface VdcRepository extends JpaRepository<Vdc, Long> {
    Optional<Vdc> findByOrderRequestid(String id);
    Optional<Vdc> findByVdcRequestid(String id);

    List<Vdc> findAllByVdcName(String vdcname);
}

package com.rms.Order.controller;

import com.rms.Order.entity.Ecm;
import com.rms.Order.entity.OrderDetail;
import com.rms.Order.repository.EcmRepository;
import com.rms.Order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ecm")
public class EcmController {
    @Autowired
    EcmRepository ecmRepository;

    @PostMapping("/addEcmRequest")
    public Ecm addEcm(@RequestBody Ecm ecm) {
        ecmRepository.save(ecm);
        return ecm;
    }

    @PutMapping("/updateEcmRequest")
    public String UpdateEcmRequest(@RequestParam String Status, @RequestParam String OrderRequestid) {
        Ecm ecm = ecmRepository.findByOrderRequestid(OrderRequestid).get();
        ecm.setECMRequest(Status);
        ecmRepository.save(ecm);
        return "Succefully Update Status ";
    }
}

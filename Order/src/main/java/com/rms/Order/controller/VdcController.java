package com.rms.Order.controller;

import com.rms.Order.entity.Ecm;
import com.rms.Order.entity.OrderDetail;
import com.rms.Order.entity.Vdc;
import com.rms.Order.repository.EcmRepository;
import com.rms.Order.repository.OrderRepository;
import com.rms.Order.repository.VdcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vdc")
public class VdcController {
    @Autowired
    VdcRepository vdcRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    EcmRepository ecmRepository;

    @PostMapping("/addVdc")
    public Vdc addVdc(@RequestBody Vdc vdc) {
        vdcRepository.save(vdc);
        return vdc;
    }

    @PutMapping("/updateVdc")
    public String updateVdc(@RequestParam String orderRequestid, @RequestParam String vdcRequestid) {
        System.out.println(vdcRequestid);
        Vdc vdc = vdcRepository.findByVdcRequestid(vdcRequestid).get();
        vdc.setOrderRequestid(orderRequestid);
        vdcRepository.save(vdc);
        return "Succefully Update Status ";
    }

    @DeleteMapping("/DeleteVdc")
    public String deleteVdc(@RequestParam String orderRequestid) {
        Vdc vdc = vdcRepository.findByOrderRequestid(orderRequestid).get();
        vdcRepository.deleteById(vdc.getId());
        return "Succefully Delete Vdc ";
    }

    @GetMapping("/getVdc")
    public Vdc getVdc(@RequestParam String OrderRequestid) {
        Vdc vdc = vdcRepository.findByOrderRequestid(OrderRequestid).get();
        return vdc;
    }

    @GetMapping("/getVdcDetail")
    public Vdc getVdcDetails(@RequestParam String vdcName) {
        List<Vdc> list = vdcRepository.findAllByVdcName(vdcName);
        if (list.size() > 1) {
            return list.get(0);
        } else {
            return null;
        }

    }

    @GetMapping("/getDetail")
    public List<Object> getDetail(@RequestParam String OrderRequestid) {
        List<Object> l1 = new ArrayList<Object>();
        Vdc vdc = vdcRepository.findByOrderRequestid(OrderRequestid).get();
        OrderDetail orderDetail = orderRepository.findByOrderRequestid(OrderRequestid).get();
        Ecm ecm = ecmRepository.findByOrderRequestid(OrderRequestid).get();
        l1.add(vdc);
        l1.add(orderDetail);
        l1.add(ecm);
        System.out.println(l1);
        return l1;
    }

}
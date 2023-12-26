package com.rms.Order.controller;

import com.rms.Order.entity.OrderDetail;
import com.rms.Order.entity.Vdc;
import com.rms.Order.repository.OrderRepository;
import com.rms.Order.repository.VdcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderdetail")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/addOrderdetail")
    public OrderDetail addOrder(@RequestBody OrderDetail orderdetail) {
        orderRepository.save(orderdetail);
        return orderdetail;
    }

    @PutMapping("/updateOrderdetail")
    public String UpdateOrder(@RequestParam String requestType, @RequestParam String Status, @RequestParam String OrderRequestid) {
        OrderDetail orderDetail = orderRepository.findByOrderRequestid(OrderRequestid).get();
        if (requestType.equals("designVdc")) {
            orderDetail.setDesignVdc(Status);
            orderRepository.save(orderDetail);
        } else if (requestType.equals("activationVdc")) {
            orderDetail.setActivationVdc(Status);
            orderRepository.save(orderDetail);
        } else if (requestType.equals("orderComplete")) {
            orderDetail.setOrderComplete(Status);
            orderRepository.save(orderDetail);
        } else if (requestType.equals("finishOrder")) {
            orderDetail.setFinishOrder(Status);
            orderRepository.save(orderDetail);
        }
        return "Succefully Update Status ";
    }

    @PutMapping("/updateOrderHandlerid")
    public String UpdateOrderHandlerid(@RequestParam String OrderHandlerid, @RequestParam String OrderRequestid) {
        OrderDetail orderDetail = orderRepository.findByOrderRequestid(OrderRequestid).get();
        orderDetail.setOrderHandlerid(OrderHandlerid);
        orderRepository.save(orderDetail);
        return "Succefully Update Status ";
    }


    }


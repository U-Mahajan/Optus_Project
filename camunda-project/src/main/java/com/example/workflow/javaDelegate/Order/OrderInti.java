package com.example.workflow.javaDelegate.Order;

import com.rms.Order.entity.OrderDetail;
import com.rms.Order.entity.Vdc;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class OrderInti implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int rand_int = ThreadLocalRandom.current().nextInt();
        Object vdcRequestid = delegateExecution.getVariable("vdcRequestid");
        Object vdcName = delegateExecution.getVariable("vdcName");
        delegateExecution.setVariable("vdcName",vdcName);
        String OrderRequestid = String.valueOf(Math.abs(rand_int));
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setVdcRequestid(vdcRequestid.toString());
        orderDetail.setOrderHandlerid("Not-Allocated");
        orderDetail.setOrderRequestid(OrderRequestid);
        orderDetail.setDesignVdc("Not-Assign");
        orderDetail.setActivationVdc("Not-Assign");
        orderDetail.setFinishOrder("Not-Assign");
        orderDetail.setOrderComplete("Not-Assign");
//        save orderdetail in Order Applicaion
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8091/api/orderdetail/addOrderdetail";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrderDetail> requestEntity = new HttpEntity<>(orderDetail, headers);
        ResponseEntity<String> responseBody = restTemplate.postForEntity(url, requestEntity, String.class);
        String responseBody1 = responseBody.getBody();
        delegateExecution.setVariable("OrderRequestid",OrderRequestid);
//        update vdc
       String vdcRequestid1 = vdcRequestid.toString();
        String url1 = "http://localhost:8091/api/vdc/updateVdc?orderRequestid="+OrderRequestid+"&vdcRequestid="+vdcRequestid1;
        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity1 = new HttpEntity<>(headers1);
        restTemplate.put(url1, requestEntity1);
    }
}
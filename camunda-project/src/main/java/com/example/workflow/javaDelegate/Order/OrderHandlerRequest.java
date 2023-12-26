package com.example.workflow.javaDelegate.Order;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class OrderHandlerRequest implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int rand_int = ThreadLocalRandom.current().nextInt();
        String orderHandlerid = String.valueOf(Math.abs(rand_int));
       String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
//        putmapping
        RestTemplate restTemplate = new RestTemplate();
        String url1 = "http://localhost:8091/api/orderdetail/updateOrderHandlerid?OrderHandlerid="+orderHandlerid+"&OrderRequestid="+OrderRequestid;
        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity1 = new HttpEntity<>(headers1);
        restTemplate.put(url1, requestEntity1);
        delegateExecution.setVariable("orderHandlerid",orderHandlerid);
        delegateExecution.setVariable("OrderRequestid",OrderRequestid);
    }

}


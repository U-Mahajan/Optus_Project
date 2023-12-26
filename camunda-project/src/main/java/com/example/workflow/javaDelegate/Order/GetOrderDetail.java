package com.example.workflow.javaDelegate.Order;

import com.rms.Order.entity.OrderDetail;
import com.rms.Order.entity.Vdc;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class GetOrderDetail implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String orderHandlerid = (String) delegateExecution.getVariable("orderHandlerid");
        String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");        RestTemplate restTemplate = new RestTemplate();
        String url1 = "http://localhost:8091/api/vdc/getVdc?OrderRequestid="+OrderRequestid;
        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity1 = new HttpEntity<>(headers1);
        Vdc vdc = restTemplate.getForObject(url1, Vdc.class);
        delegateExecution.setVariable("vdcName",vdc.getVdcName());
        delegateExecution.setVariable("OrderRequestid",OrderRequestid);
    }
}

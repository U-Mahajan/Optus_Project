package com.example.workflow.javaDelegate.Order;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HandleActivationComplete implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String vdcName = (String) delegateExecution.getVariable("vdcName");
        String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
        String requestType = "activationVdc";
        String Status = vdcName+"-Complete";
        String url1 = "http://localhost:8091/api/orderdetail/updateOrderdetail?requestType="+requestType+
                "&Status="+Status+"&OrderRequestid="+OrderRequestid;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity1 = new HttpEntity<>(headers1);
        restTemplate.put(url1, requestEntity1);
    }
}

package com.example.workflow.javaDelegate.RequestResponce;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EcmResponce implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String ECMRequest = "Approved";
    //putmapping
        delegateExecution.setVariable("ECMRequest","Approved");
        String ECMRequestType = (String) delegateExecution.getVariable("ECMRequestType");
        if(ECMRequestType.equals("create")) {
            String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
            RestTemplate restTemplate = new RestTemplate();
            String url1 = "http://localhost:8091/api/ecm/updateEcmRequest?Status=Approved&OrderRequestid=" + OrderRequestid;
            HttpHeaders headers1 = new HttpHeaders();
            headers1.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> requestEntity1 = new HttpEntity<>(headers1);
            restTemplate.put(url1, requestEntity1);
            System.out.println("OrderRequestid = "+OrderRequestid);
        } else if (ECMRequestType.equals("delete")){
            RestTemplate restTemplate = new RestTemplate();
            String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
            String url2 = "http://localhost:8091/api/vdc/DeleteVdc?orderRequestid="+OrderRequestid;
            HttpHeaders headers2 = new HttpHeaders();
            headers2.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> requestEntity2 = new HttpEntity<>(headers2);
            restTemplate.delete(url2, requestEntity2);
            System.out.println("OrderRequestid = "+OrderRequestid);
        }
    }
}

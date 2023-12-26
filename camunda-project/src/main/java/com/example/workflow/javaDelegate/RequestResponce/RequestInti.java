package com.example.workflow.javaDelegate.RequestResponce;

import com.rms.Order.entity.Ecm;
import com.rms.Order.entity.OrderDetail;
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
public class RequestInti implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String vdcName = (String) delegateExecution.getVariable("vdcName");
        int rand_int = ThreadLocalRandom.current().nextInt();
        String ECMRequestid = String.valueOf(Math.abs(rand_int));
        String ECMRequestType = (String) delegateExecution.getVariable("ECMRequestType");
        if (ECMRequestType.equals("create")) {
            String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
            Ecm ecm = new Ecm();
            ecm.setVdcName(vdcName);
            ecm.setECMRequest("NA");
            ecm.setECMRequestid(ECMRequestid);
            ecm.setECMRequestType(ECMRequestType);
            ecm.setOrderRequestid(OrderRequestid);
//        save file
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8091/api/ecm/addEcmRequest";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Ecm> requestEntity = new HttpEntity<>(ecm, headers);
            ResponseEntity<String> responseBody = restTemplate.postForEntity(url, requestEntity, String.class);
        }else if (ECMRequestType.equals("delete")){
            int rand_int1 = ThreadLocalRandom.current().nextInt();
//            String OrderRequestid = String.valueOf(Math.abs(rand_int1));
            String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
            Ecm ecm = new Ecm();
            ecm.setVdcName(vdcName);
            ecm.setECMRequest("Approved");
            ecm.setECMRequestid(ECMRequestid);
            ecm.setECMRequestType(ECMRequestType);
            ecm.setOrderRequestid(OrderRequestid);
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8091/api/ecm/addEcmRequest";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Ecm> requestEntity = new HttpEntity<>(ecm, headers);
            ResponseEntity<String> responseBody = restTemplate.postForEntity(url, requestEntity, String.class);
            delegateExecution.setVariable("OrderRequestid",OrderRequestid);
        }
    }

}

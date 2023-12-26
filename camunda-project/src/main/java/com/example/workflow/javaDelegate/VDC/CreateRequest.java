package com.example.workflow.javaDelegate.VDC;

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
public class CreateRequest implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int rand_int = ThreadLocalRandom.current().nextInt();
        int rand_int1 = ThreadLocalRandom.current().nextInt();
        String vdcRequestid = String.valueOf(Math.abs(rand_int));
        String name = (String) delegateExecution.getVariable("name");
        String vdcName = (String) delegateExecution.getVariable("vdcName");
        String description = (String) delegateExecution.getVariable("description");
        String vimZoneName = (String) delegateExecution.getVariable("vimZoneName");
        long id = Math.abs(rand_int1);
        Vdc vdc = new Vdc();
        vdc.setId(id);
        vdc.setVdcName(vdcName);
        vdc.setDescription(description);
        vdc.setVdcRequestid(vdcRequestid);
        vdc.setName(name);
        vdc.setVimZoneName(vimZoneName);
        vdc.setOrderRequestid("Na");
//        save vdc-order in Order application
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8091/api/vdc/addVdc";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Vdc> requestEntity = new HttpEntity<>(vdc, headers);
        ResponseEntity<String> responseBody = restTemplate.postForEntity(url, requestEntity, String.class);
        String responseBody1 = responseBody.getBody();
        delegateExecution.setVariable("vdcRequestid",vdcRequestid);
    }
}

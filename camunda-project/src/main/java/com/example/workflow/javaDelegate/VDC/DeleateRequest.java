package com.example.workflow.javaDelegate.VDC;

import com.rms.Order.entity.Vdc;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleateRequest implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String vdcName = (String) delegateExecution.getVariable("vdcName");
        String url1 = "http://localhost:8091/api/vdc/getVdcDetail?vdcName=" + vdcName;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity1 = new HttpEntity<>(headers1);
        Vdc vdc = restTemplate.getForObject(url1, Vdc.class);
        if (vdc != null) {
            delegateExecution.setVariable("OrderRequestid", vdc.getOrderRequestid());
            delegateExecution.setVariable("vdcName", vdc.getVdcName());
            delegateExecution.setVariable("vdcStatus", "Yes");
        } else if (vdc == null) {
            throw new BpmnError("Create Vdc","No Repeat VDC Order");

        }
    }
}

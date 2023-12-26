package com.example.workflow.javaDelegate.VDC;

import com.rms.Order.entity.Vdc;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class OrderVdc implements DelegateVariableMapping {

    @Override
    public void mapInputVariables(DelegateExecution delegateExecution, VariableMap variableMap) {
        Object vdcRequestid =  delegateExecution.getVariable("vdcRequestid");
        Object vdcName =  delegateExecution.getVariable("vdcName");
        variableMap.put("vdcRequestid",vdcRequestid.toString());
        variableMap.put("vdcName",vdcName.toString());
    }

    @Override
    public void mapOutputVariables(DelegateExecution delegateExecution, VariableScope variableScope) {

    }
}

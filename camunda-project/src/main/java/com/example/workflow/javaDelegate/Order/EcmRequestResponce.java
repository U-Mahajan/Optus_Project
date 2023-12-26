package com.example.workflow.javaDelegate.Order;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;

@Component
public class EcmRequestResponce implements DelegateVariableMapping {

    @Override
    public void mapInputVariables(DelegateExecution delegateExecution, VariableMap variableMap) {
        Object obj = delegateExecution.getVariable("OrderRequestid");
        Object obj1 = delegateExecution.getVariable("vdcName");
        variableMap.put("vdcName", obj1.toString());
        variableMap.put("OrderRequestid", obj.toString());
        variableMap.put("ECMRequestType","create");
    }

    @Override
    public void mapOutputVariables(DelegateExecution delegateExecution, VariableScope variableScope) {
      String ECMRequest = (String) variableScope.getVariable("ECMRequest");
        String OrderRequestid = (String) variableScope.getVariable("OrderRequestid");

    }
}

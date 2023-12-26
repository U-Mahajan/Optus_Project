package com.example.workflow.javaDelegate.Order;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;

@Component
public class SendOrderDetails implements DelegateVariableMapping {

    @Override
    public void mapInputVariables(DelegateExecution delegateExecution, VariableMap variableMap) {
        String orderHandlerid = (String) delegateExecution.getVariable("orderHandlerid");
        String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
        variableMap.put("OrderRequestid",OrderRequestid);
        variableMap.put("orderHandlerid",orderHandlerid);
    }

    @Override
    public void mapOutputVariables(DelegateExecution delegateExecution, VariableScope variableScope) {
       String vdcName = (String) variableScope.getVariable("vdcName");
        String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
        delegateExecution.setVariable("vdcName",vdcName);
        delegateExecution.setVariable("OrderRequestid",OrderRequestid);
    }
}

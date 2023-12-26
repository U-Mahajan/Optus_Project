package com.example.workflow.javaDelegate.VDC;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;

@Component
public class DeleteVdc implements DelegateVariableMapping {
    @Override
    public void mapInputVariables(DelegateExecution delegateExecution, VariableMap variableMap) {
        String vdcName = (String) delegateExecution.getVariable("vdcName");
        String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
        variableMap.put("vdcName",vdcName);
        variableMap.put("OrderRequestid",OrderRequestid);
        variableMap.put("ECMRequestType","delete");
    }
    @Override
    public void mapOutputVariables(DelegateExecution delegateExecution, VariableScope variableScope) {

    }
}

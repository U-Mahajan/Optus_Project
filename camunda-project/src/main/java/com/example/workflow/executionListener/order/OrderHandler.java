package com.example.workflow.executionListener.order;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class OrderHandler implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
       String ss = (String) delegateExecution.getVariable("order");
        delegateExecution.setVariable("order",ss);
    }
}

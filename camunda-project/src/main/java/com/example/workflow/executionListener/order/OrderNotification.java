package com.example.workflow.executionListener.order;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class OrderNotification implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        String orderStatus = (String) delegateExecution.getVariable("orderStatus");
        delegateExecution.setVariable("order",orderStatus);
        String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
        if(orderStatus.equals("orderactivate") || orderStatus.equals("orderdesign")) {
            delegateExecution.setVariable("orderdetail", "yes");
        } else if(orderStatus.equals("ordercomplete")) {
            delegateExecution.setVariable("orderdetail", "no");
        }
    }
}

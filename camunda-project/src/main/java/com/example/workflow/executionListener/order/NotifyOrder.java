package com.example.workflow.executionListener.order;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class NotifyOrder implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setProcessBusinessKey("name");
        String OrderRequestid = (String) delegateExecution.getVariable("OrderRequestid");
        RuntimeService runtimeService = delegateExecution.getProcessEngineServices().getRuntimeService();
        List<MessageCorrelationResult> results = runtimeService
                .createMessageCorrelation("order_approved").processInstanceBusinessKey("name").setVariable("orderStatus", "orderdesign").setVariable("OrderRequestid", OrderRequestid)
                .processInstanceVariableEquals("data","done")
                .correlateAllWithResult();

    }

}


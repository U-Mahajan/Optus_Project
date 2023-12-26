package com.example.workflow.javaDelegate.Order;

import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerNotification implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String handleStatus = (String) delegateExecution.getVariable("handleStatus");
        delegateExecution.setProcessBusinessKey("name");
        delegateExecution.setVariable("orderStatus", handleStatus);
        delegateExecution.setVariable("dd", "done");
        RuntimeService runtimeService1 = delegateExecution.getProcessEngineServices().getRuntimeService();
        String executionId = delegateExecution.getId();
        String eventName = "order_approved";
        if (handleStatus.equals("designcomplete")) {
            List<MessageCorrelationResult> results = runtimeService1
                    .createMessageCorrelation("order_approved").setVariable("orderStatus", "orderactivate")
                    .processInstanceVariableEquals("data", "done")
                    .correlateAllWithResult();
        } else if (handleStatus.equals("activecomplete")) {
            List<MessageCorrelationResult> results = runtimeService1
                    .createMessageCorrelation("order_approved").setVariable("orderStatus", "ordercomplete")
                    .processInstanceVariableEquals("data", "done")
                    .correlateAllWithResult();
        }
    }
}

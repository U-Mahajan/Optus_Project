package com.example.workflow.executionListener.VDC;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class ErrorVdc implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        String code = (String) delegateExecution.getVariable("messagecode");
        String codemessage = (String) delegateExecution.getVariable("messagevariable");
        delegateExecution.setVariable("message", codemessage);

    }
}

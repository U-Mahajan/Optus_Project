package com.example.workflow.executionListener.VDC;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import java.beans.ExceptionListener;

@Component
public class TaskUpdate implements ExecutionListener {

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("vdcStatus", "Yes");

    }
}

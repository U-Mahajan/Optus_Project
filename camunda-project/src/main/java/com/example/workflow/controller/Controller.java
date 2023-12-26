package com.example.workflow.controller;

import com.rms.Order.entity.Vdc;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private ProcessEngine camunda;

    @PostMapping("/start")
    public void start(@RequestBody Vdc vdc ) {

        camunda.getRuntimeService().startProcessInstanceByKey(
                "my-project-process", Variables.putValue("name", vdc.getName())
                        .putValue("vdcName",vdc.getVdcName())
                        .putValue("description",vdc.getDescription())
                        .putValue("vimZoneName",vdc.getVimZoneName())
                        .putValue("vdcRequestid",vdc.getVdcRequestid()));

    }

}

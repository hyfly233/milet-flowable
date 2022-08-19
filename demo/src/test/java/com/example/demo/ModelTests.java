package com.example.demo;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.ui.modeler.domain.Model;
import org.flowable.ui.modeler.serviceapi.ModelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ModelTests {

    @Autowired
    private ModelService modelService;

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void contextLoads() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    void deployByModel() {
        String modelId = "406f1bfb-139d-11ed-bbbe-d23c1f5533c2";

        Model model = modelService.getModel(modelId);
        BpmnModel bpmnModel = modelService.getBpmnModel(model);
        Deployment deploy = repositoryService.createDeployment()
                .name(model.getName())
                .addBpmnModel(model.getKey() + ".bpmn", bpmnModel)
                .deploy();

        System.out.println(deploy.getId());
    }
}

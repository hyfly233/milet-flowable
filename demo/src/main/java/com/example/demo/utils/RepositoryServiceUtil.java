package com.example.demo.utils;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;

public class RepositoryServiceUtil {

    /**
     * 部署流程定义
     *
     * @param repositoryService 流程引擎的仓库服务
     * @param fileName          流程定义文件名称
     */
    public static void deployment(RepositoryService repositoryService, String fileName) {
        String filePath = "processes";

        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource(filePath + "/" + fileName)
                .name(fileName)
                .category(fileName)
                .key(fileName + ".Key")
                .deploy();

        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }

    /**
     * 获取流程定义的信息
     *
     * @param repositoryService 流程引擎的仓库服务
     */
    public static void getProcessDefinition(RepositoryService repositoryService) {
        repositoryService.createDeploymentQuery().list().forEach(i -> {
            System.out.println("Id: " + i.getId());
            System.out.println("Name: " + i.getName());
            System.out.println("Key: " + i.getKey());
            System.out.println("Category: " + i.getCategory());
            System.out.println("TenantId: " + i.getTenantId());
            System.out.println("DeploymentTime: " + i.getDeploymentTime());
        });
    }


    /**
     * 删除流程实例的定义信息
     *
     * @param repositoryService 流程引擎的仓库服务
     * @param deploymentId      部署的id
     */
    public static void deleteProcessDefinition(RepositoryService repositoryService, String deploymentId) {
        repositoryService.deleteDeployment(deploymentId, true);
    }
}

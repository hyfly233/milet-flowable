package com.example.springbootdemo;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired final RepositoryService repositoryService,
                                  @Autowired final RuntimeService runtimeService,
                                  @Autowired final TaskService taskService) {

        return strings -> {
            System.out.println("Number of process definitions : " + repositoryService.createProcessDefinitionQuery().count());
            System.out.println("Number of tasks : " + taskService.createTaskQuery().count());

            runtimeService.startProcessInstanceByKey("oneTaskProcess");

            System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
        };
    }
}

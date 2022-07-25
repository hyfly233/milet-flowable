package com.example.springbootdemo;

import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.util.HashMap;

@SpringBootTest
public class UelTests {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Test
    void contextLoads() {
    }

    /**
     * 通过参数创建流程定义
     */
    @Test
    void initProcessInstanceWithArgs() {
        // 参数是一个 map 结构
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process", "test", new HashMap<>(2) {{
            put("name", "张三");
            put("age", "18");
        }});

        System.out.println(processInstance.getId());
    }

    /**
     * 通过参数完成流程实例
     */
    @Test
    void completeTaskWithArgs() {
        // 参数是一个 map 结构
        taskService.complete("task", new HashMap<>(2) {{
            put("name", "张三");
            put("age", "18");
        }});
    }

    /**
     * 通过参数创建流程定义
     */
    @Test
    void initProcessInstanceWithClassArgs() {
        Person person = new Person().setName("张三").setAge("18");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process", "test", new HashMap<>(1) {{
            put("person", person);
        }});

        System.out.println(processInstance.getId());
    }

    /**
     * 通过参数完成流程实例，指定多个候选人
     */
    @Test
    void completeTaskWithCandidateArgs() {
        // 参数是一个 map 结构
        taskService.complete("task", new HashMap<>(1) {{
            put("候选人", "张三,李四,王五");
        }});
    }

    /**
     * 直接指定流程变量
     */
    @Test
    void otherArgs() {
        runtimeService.setVariable("process", "name", "张三");
        runtimeService.setVariables("process", new HashMap<>(2) {{
            put("name", "张三");
            put("age", "18");
        }});
    }

    /**
     * 直接指定流程局部变量
     */
    @Test
    void otherLocalArgs() {
        runtimeService.setVariableLocal("process", "name", "张三");
        runtimeService.setVariablesLocal("process", new HashMap<>(2) {{
            put("name", "张三");
            put("age", "18");
        }});
    }

    static class Person implements Serializable {
        String name;
        String age;

        public String getName() {
            return name;
        }

        public Person setName(String name) {
            this.name = name;
            return this;
        }

        public String getAge() {
            return age;
        }

        public Person setAge(String age) {
            this.age = age;
            return this;
        }
    }
}

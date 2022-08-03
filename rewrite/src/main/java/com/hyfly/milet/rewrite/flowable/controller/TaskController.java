package com.hyfly.milet.rewrite.flowable.controller;


import com.hyfly.milet.rewrite.pojo.vo.Result;
import org.flowable.engine.FormService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/flow/task")
public class TaskController {

    private static final String TASK_COMMENT = "comment";
    @Autowired
    FormService formService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;

//    @Autowired
//    private SysBaseApiImpl sysBaseApiImpl;

//    /**
//     * 查询我的待办任务列表
//     */
//    @GetMapping("/taskList")
//    @ResponseBody
//    public Result<?> taskList(TaskQueryParam param) {
////        LoginUser user = (LoginUser) SecurityUtils.getSubject().getPrincipal();
//
////       todo String username = user.getUsername();
//        String username = "admin";
//        TaskQuery taskQuery = taskService.createTaskQuery().taskAssignee(username);
//        if (StringUtils.isNotBlank(param.getTaskName())) {
//            taskQuery.taskName(param.getTaskName());
//        }
//        if (StringUtils.isNotBlank(param.getProcessName())) {
//            taskQuery.processDefinitionName(param.getProcessName());
//        }
//        // 过滤掉流程挂起的待办任务
//        int total = taskQuery.active().orderByTaskCreateTime().desc().list().size();
//        int start = (param.getPageNum() - 1) * param.getPageSize();
//        List<Task> taskList = taskQuery.active().orderByTaskCreateTime().desc().listPage(start, param.getPageSize());
//        List<TaskVo> tasks = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        taskList.forEach(a -> {
//            ProcessInstance process = runtimeService.createProcessInstanceQuery().processInstanceId(a.getProcessInstanceId()).singleResult();
//            TaskVo info = new TaskVo();
//            info.setAssignee(a.getAssignee());
//            info.setBusinessKey(process.getBusinessKey());
//            info.setCreateTime(sdf.format(a.getCreateTime()));
//            info.setTaskName(a.getName());
//            info.setExecutionId(a.getExecutionId());
//            info.setProcessInstanceId(a.getProcessInstanceId());
//            info.setProcessName(process.getProcessDefinitionName());
//            info.setStarter(process.getStartUserId());
//            info.setStartTime(sdf.format(process.getStartTime()));
//            info.setTaskId(a.getId());
//            String formKey = formService.getTaskFormData(a.getId()).getFormKey();
//            info.setFormKey(formKey);
//            tasks.add(info);
//        });
//        return Result.OK(tasks);
//    }

//    /**
//     * 查询所有待办任务列表
//     */
//    @GetMapping("/allTask")
//    @ResponseBody
//    public Result<?> allTask(TaskQueryParam param) {
//        TaskQuery condition = taskService.createTaskQuery();
//        if (StringUtils.isNotBlank(param.getTaskName())) {
//            condition.taskName(param.getTaskName());
//        }
//        if (StringUtils.isNotBlank(param.getProcessName())) {
//            condition.processDefinitionName(param.getProcessName());
//        }
//        int total = condition.active().orderByTaskCreateTime().desc().list().size();
//        int start = (param.getPageNum() - 1) * param.getPageSize();
//        List<Task> taskList = condition.active().orderByTaskCreateTime().desc().listPage(start, param.getPageSize());
//        List<TaskVo> tasks = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        taskList.forEach(a -> {
//            ProcessInstance process = runtimeService.createProcessInstanceQuery().processInstanceId(a.getProcessInstanceId()).singleResult();
//            TaskVo info = new TaskVo();
//            info.setAssignee(a.getAssignee());
//            info.setBusinessKey(process.getBusinessKey());
//            info.setCreateTime(sdf.format(a.getCreateTime()));
//            info.setTaskName(a.getName());
//            info.setExecutionId(a.getExecutionId());
//            info.setProcessInstanceId(a.getProcessInstanceId());
//            info.setProcessName(process.getProcessDefinitionName());
//            info.setStarter(process.getStartUserId());
//            info.setStartTime(sdf.format(process.getStartTime()));
//            info.setTaskId(a.getId());
//            String formKey = formService.getTaskFormData(a.getId()).getFormKey();
//            info.setFormKey(formKey);
//            tasks.add(info);
//        });
//        return Result.OK(tasks);
//    }

    @PostMapping(value = "/claimTask/{taskId}")
    @ResponseBody
    public Result<?> claimTask(@PathVariable("taskId") String taskId, @RequestBody(required = false) Map<String, Object> variables) {
//        LoginUser user = (LoginUser) SecurityUtils.getSubject().getPrincipal();
//        todo String username = user.getUsername();
        String username = "admin";
        taskService.claim(taskId, username);
        return Result.OK();
    }

    @PostMapping(value = "/completeTask/{taskId}")
    @ResponseBody
    public Result<?> completeTask(@PathVariable("taskId") String taskId, @RequestBody(required = false) Map<String, Object> variables) {
//        LoginUser user = (LoginUser) SecurityUtils.getSubject().getPrincipal();
//        todo String username = user.getUsername();
        String username = "admin";

        // todo 接收任务是否该单独提出去
        taskService.claim(taskId, username);
        // 查出流程实例id
        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
        if (variables == null) {
            taskService.complete(taskId);
        } else {
            // 添加审批意见
            if (variables.get(TASK_COMMENT) != null) {
                taskService.addComment(taskId, processInstanceId, (String) variables.get("comment"));
                variables.remove(TASK_COMMENT);
            }
            taskService.complete(taskId, variables);
        }
        return Result.OK();
    }

//    @GetMapping(value = "/history/{taskId}")
//    @ResponseBody
//    public Result<List<TaskVo>> history(@PathVariable String taskId) {
//        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
//        List<HistoricActivityInstance> history = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).activityType("userTask").orderByHistoricActivityInstanceStartTime().asc().list();
//        List<TaskVo> infos = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        history.forEach(h -> {
//            TaskVo info = new TaskVo();
//            info.setProcessInstanceId(h.getProcessInstanceId());
//            info.setStartTime(sdf.format(h.getStartTime()));
//            if (h.getEndTime() != null) {
//                info.setEndTime(sdf.format(h.getEndTime()));
//            }
//            info.setAssignee(h.getAssignee());
//            info.setTaskName(h.getActivityName());
//            List<Comment> comments = taskService.getTaskComments(h.getTaskId());
//            if (comments.size() > 0) {
//                info.setComment(comments.get(0).getFullMessage());
//            }
//            infos.add(info);
//        });
//        return Result.OK(infos);
//    }
}
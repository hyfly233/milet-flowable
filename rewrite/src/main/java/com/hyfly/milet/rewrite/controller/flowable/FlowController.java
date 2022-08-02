package com.hyfly.milet.rewrite.controller.flowable;

import com.hyfly.milet.rewrite.pojo.vo.ProcessVo;
import com.hyfly.milet.rewrite.pojo.vo.Result;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.repository.ProcessDefinitionQuery;
import org.flowable.image.ProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * 流程管理
 */
@Controller
@RequestMapping("/flow/manage")
public class FlowController {

    private static final String PREFIX = "flowable/manage";
    private static final String FILE_TYPE_ZIP = "zip";
    private static final String FILE_TYPE_BPMN = "bpmn2";
    private static final String FILE_TYPE_XML = "bpmn20.xml";


    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ProcessEngineConfiguration configuration;

    @GetMapping("/processLists")
    @ResponseBody
    public Result<?> getlist(@RequestParam(required = false) String key, @RequestParam(required = false) String name,
                             Integer pageSize, Integer pageNum) {
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        if (StringUtils.isNotBlank(key)) {
            query.processDefinitionKey(key);
        }
        if (StringUtils.isNotBlank(name)) {
            query.processDefinitionName(name);
        }
        int start = (pageNum - 1) * pageSize;
        int total = query.list().size();
        List<ProcessDefinition> pageList = query.listPage(start, pageSize);
        List<ProcessVo> list = new ArrayList<>();

        pageList.forEach(processDefinition -> {
            ProcessVo p = new ProcessVo();
            p.setDeploymentId(processDefinition.getDeploymentId());
            p.setId(processDefinition.getId());
            p.setKey(processDefinition.getKey());
            p.setName(processDefinition.getName());
            p.setResourceName(processDefinition.getResourceName());
            p.setDiagramResourceName(processDefinition.getDiagramResourceName());
            list.add(p);
        });

        return Result.OK(list);
    }

    @GetMapping(value = "/resource/png/{pid}")
    public void resource(@PathVariable("pid") String pid, HttpServletResponse response) throws Exception {
        BpmnModel bpmnModel = repositoryService.getBpmnModel(pid);
        ProcessDiagramGenerator diagramGenerator = configuration.getProcessDiagramGenerator();
        InputStream is = diagramGenerator.generateDiagram(bpmnModel, "png", "宋体", "宋体", "宋体", configuration.getClassLoader(), true);
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is, output);
    }

    @GetMapping(value = "/processDefinition/{pid}/{resource}")
    public void showProcessDefinition(@PathVariable("pid") String pid, @PathVariable(value = "resource") String resource, HttpServletResponse response) throws Exception {
        InputStream is = repositoryService.getResourceAsStream(pid, resource);
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is, output);
    }

    @PostMapping("/flowableFileUpload")
    @ResponseBody
    public Result<?> flowableFileUpload(@RequestParam MultipartFile uploadFile) {
        try {
            String filename = uploadFile.getOriginalFilename();
            InputStream is = uploadFile.getInputStream();

            if (StringUtils.isNotBlank(filename)) {
                if (filename.endsWith(FILE_TYPE_ZIP)) {
                    repositoryService.createDeployment().name(filename).addZipInputStream(new ZipInputStream(is)).deploy();
                } else if (filename.endsWith(FILE_TYPE_BPMN) || filename.endsWith(FILE_TYPE_XML)) {
                    repositoryService.createDeployment().name(filename).addInputStream(filename, is).deploy();
                } else {
                    return Result.error("文件格式错误");
                }
            } else {
                return Result.error("文件为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("部署失败");
        }
        return Result.OK("部署成功");
    }

    @DeleteMapping("/{deploymentId}")
    @ResponseBody
    public Result<String> remove(@PathVariable String deploymentId) {
        repositoryService.deleteDeployment(deploymentId, true);
        return Result.OK("删除成功");
    }
}

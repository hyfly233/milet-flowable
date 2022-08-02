package com.hyfly.milet.rewrite;

import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.LeaveApplyParam;
import com.hyfly.milet.rewrite.service.LeaveProcessWithListenerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class LeaveProcessWithListenerTests {

    @Autowired
    private LeaveProcessWithListenerService leaveProcessService;

    @Test
    void contextLoads() {
    }

    @Test
    void startLeaveProcess() {
        LeaveApplyParam param = LeaveApplyParam.builder()
                .userId("4")
                .applyTime(new Date())
                .assigneeType("group")
                .assigneeDeptGroup("1")
                .build();

        leaveProcessService.startLeaveProcess(param);
    }
}

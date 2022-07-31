package com.hyfly.milet.rewrite.pojo.dto.LeaveProcess;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HrApprovalDto {

    private String taskId;

    private String isApproval;

    private String comment;
}

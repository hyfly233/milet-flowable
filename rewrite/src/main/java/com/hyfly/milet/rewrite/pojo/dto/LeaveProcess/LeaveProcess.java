package com.hyfly.milet.rewrite.pojo.dto.LeaveProcess;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 请假表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeaveProcess {
    /**
     * 主键
     */
    private String id;

    /**
     * 请假人
     */
    private String userId;

    /**
     * 起始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 类型
     */
    private String leaveType;

    /**
     * 原因
     */
    private String reason;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 实际起始时间
     */
    private Date realityStartTime;

    /**
     * 实际结束时间
     */
    private Date realityEndTime;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_START_TIME = "start_time";

    public static final String COL_END_TIME = "end_time";

    public static final String COL_LEAVE_TYPE = "leave_type";

    public static final String COL_REASON = "reason";

    public static final String COL_APPLY_TIME = "apply_time";

    public static final String COL_REALITY_START_TIME = "reality_start_time";

    public static final String COL_REALITY_END_TIME = "reality_end_time";
}
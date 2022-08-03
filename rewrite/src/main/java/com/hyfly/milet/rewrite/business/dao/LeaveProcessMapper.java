package com.hyfly.milet.rewrite.business.dao;

import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.LeaveApplyParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeaveProcessMapper {
    void insertLeaveProcess(LeaveApplyParam param);
}

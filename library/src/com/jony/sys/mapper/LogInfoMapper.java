package com.jony.sys.mapper;

import java.util.List;

import com.jony.sys.domain.LogInfo;

public interface LogInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogInfo record);

    int insertSelective(LogInfo record);

    LogInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogInfo record);

    int updateByPrimaryKey(LogInfo record);
    
    /*
     * ≤È—Ø»’÷æ
     */
    List<LogInfo> queryAllLogInfo(LogInfo logInfo);
}
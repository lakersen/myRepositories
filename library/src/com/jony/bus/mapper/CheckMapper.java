package com.jony.bus.mapper;

import java.util.List;

import com.jony.bus.domain.Check;

public interface CheckMapper {
    int deleteByPrimaryKey(String checkid);

    int insert(Check record);

    int insertSelective(Check record);

    Check selectByPrimaryKey(String checkid);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);
    
    /*
     * ≤È—Ø
     */
    List<Check> queryAllCheck(Check check);
}
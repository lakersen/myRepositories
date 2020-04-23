package com.jony.bus.mapper;

import java.util.List;

import com.jony.bus.domain.Rent;
import com.jony.bus.vo.RentVo;

public interface RentMapper {
    int deleteByPrimaryKey(String rentid);

    int insert(Rent record);

    int insertSelective(Rent record);

    Rent selectByPrimaryKey(String rentid);

    int updateByPrimaryKeySelective(Rent record);

    int updateByPrimaryKey(Rent record);

	List<Rent> queryAllRent(RentVo rentVo);
}
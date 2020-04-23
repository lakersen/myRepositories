package com.jony.bus.mapper;

import java.util.List;

import com.jony.bus.domain.Book;


public interface BookMapper {
    int deleteByPrimaryKey(String carnumber);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String carnumber);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    
    List<Book> queryAllCar(Book car);
}
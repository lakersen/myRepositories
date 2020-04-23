package com.jony.sys.mapper;

import java.util.List;

import com.jony.sys.domain.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
    
    
    /*
     * ��ѯ
     */
    List<News> queryAllNews(News news);
}
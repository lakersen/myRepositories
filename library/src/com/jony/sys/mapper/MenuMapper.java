package com.jony.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jony.sys.domain.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> queryAllMenu(Menu menu);

	void deleteRoleMenuByMid(Integer id);

	Integer queryMenuByPid(Integer pid);

	List<Menu> queryMenuByRoleId(@Param("available")Integer available, @Param("rid")Integer roleid);

	List<Menu> queryMenuByUid(@Param("available")Integer available,@Param("uid") Integer userId);
	
}
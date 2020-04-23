package com.jony.sys.service;

import java.util.List;

import com.jony.sys.domain.Menu;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.MenuVo;

//菜单管理的服务接口
public interface MenuService {
	
	//查询所有菜单返回
	public List<Menu> queryAllMenuForList(MenuVo menuVo);
	
	//根据用户id查询用户的可用菜单
	public List<Menu> queryMenuByUserIdForList(MenuVo menuVo,Integer userId);
	
	//查询所有菜单
	public DataGridView queryAllMenu(MenuVo menuVo);
	
	/*
	 * 添加菜单
	 */
	public void addMenu(MenuVo menuVo);
	
	/*
	 * 修改菜单
	 */
	public void updateMenu(MenuVo menuVo);
	
	/*
	 * 根据pid查询菜单数量
	 */
	public Integer queryMenuByPid(Integer pid);
	
	/*
	 * 根据id删除菜单
	 */
	public void deleteMenu(MenuVo menuVo);

}

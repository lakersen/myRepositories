package com.jony.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jony.sys.domain.Menu;
import com.jony.sys.mapper.MenuMapper;
import com.jony.sys.service.MenuService;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.MenuVo;
@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	

	@Override
	public List<Menu> queryAllMenuForList(MenuVo menuVo) {
		return menuMapper.queryAllMenu(menuVo);
	}

	//����Ȩ�޹������֮��������
	@Override
	public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId) {
		return menuMapper.queryMenuByUid(menuVo.getAvailable(),userId);
	}

	@Override
	public DataGridView queryAllMenu(MenuVo menuVo) {

		Page<Object>page =PageHelper.startPage(menuVo.getPage(),menuVo.getLimit());
		List<Menu>data=this.menuMapper.queryAllMenu(menuVo);
		return new DataGridView(page.getTotal(),data);
	}

	@Override
	public void addMenu(MenuVo menuVo) {
		this.menuMapper.insertSelective(menuVo);
	}

	@Override
	public void updateMenu(MenuVo menuVo) {
		this.menuMapper.updateByPrimaryKeySelective(menuVo);
	}

	@Override
	public Integer queryMenuByPid(Integer pid) {
		return this.menuMapper.queryMenuByPid(pid);
	}

	@Override
	public void deleteMenu(MenuVo menuVo) {

		//ɾ���˵��������
		this.menuMapper.deleteByPrimaryKey(menuVo.getId());
		
		//���ݲ˵�idɾ��sys_role_menu���������
		this.menuMapper.deleteRoleMenuByMid(menuVo.getId());
	}

}

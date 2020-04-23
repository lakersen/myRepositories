package com.jony.sys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jony.sys.constast.SysConstast;
import com.jony.sys.domain.Menu;
import com.jony.sys.domain.User;
import com.jony.sys.service.MenuService;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.utils.ResultObj;
import com.jony.sys.utils.TreeNode;
import com.jony.sys.utils.TreeNodeBuilder;
import com.jony.sys.utils.WebUtils;
import com.jony.sys.vo.MenuVo;

//�˵����������
@RestController
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping("loadIndexLeftMenuJson")
	public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo) {
		// �õ���ǰ��½���û�����
		User user = (User) WebUtils.getHttpSession().getAttribute("user");
		List<Menu> list = null;
		menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);// ֻ��ѯ���õ�
		if (user.getType() == SysConstast.USER_TYPE_SUPER) {
			list = this.menuService.queryAllMenuForList(menuVo);
		} else {
			list = this.menuService.queryMenuByUserIdForList(menuVo, user.getUserid());
		}
		List<TreeNode> nodes = new ArrayList<>();
		// ��list��������ݷŵ�nodes
		for (Menu menu : list) {
			Integer id = menu.getId();
			Integer pid = menu.getPid();
			String title = menu.getTitle();
			String icon = menu.getIcon();
			String href = menu.getHref();
			Boolean spread = menu.getSpread() == SysConstast.SPREAD_TRUE ? true : false;
			String target = menu.getTarget();
			nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
		}
		return TreeNodeBuilder.builder(nodes, 1);
	}

	/**
	 * ���ز˵�������ߵĲ˵���
	 */
	@RequestMapping("loadMenuManagerLeftTreeJson")
	public DataGridView loadMenuManagerLeftTreeJson(MenuVo menuVo) {
		menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);// ֻ��ѯ���õ�
		List<Menu> list = this.menuService.queryAllMenuForList(menuVo);
		List<TreeNode> nodes = new ArrayList<>();
		// ��list��������ݷŵ�nodes
		for (Menu menu : list) {
			Integer id = menu.getId();
			Integer pid = menu.getPid();
			String title = menu.getTitle();
			String icon = menu.getIcon();
			String href = menu.getHref();
			Boolean spread = menu.getSpread() == SysConstast.SPREAD_TRUE ? true : false;
			String target = menu.getTarget();
			nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
		}
		return new DataGridView(nodes);
	}

	/**
	 * ���ز˵��б���DataGridView
	 */
	@RequestMapping("loadAllMenu")
	public DataGridView loadAllMenu(MenuVo menuVo) {
		return this.menuService.queryAllMenu(menuVo);
	}
	
	/*
	 * ��Ӳ˵�
	 */
	@RequestMapping("addMenu")
	public ResultObj addMenu(MenuVo menuVo) {
		try {
			this.menuService.addMenu(menuVo);
			return ResultObj.ADD_SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	/*
	 * �޸Ĳ˵�
	 */
	@RequestMapping("updateMenu")
	public ResultObj updateMenu(MenuVo menuVo) {
		try {
			this.menuService.updateMenu(menuVo);
			return ResultObj.UPDATE_SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}

	/**
	 * ����id�жϵ�ǰ�˵���û���ӽڵ�
	 * �з���code>=0
	 * û�� ����code<0
	 */
	@RequestMapping("checkMenuHasChildren")
	public ResultObj checkMenuHasChildren(MenuVo menuVo){
		//����pid��ѯ�˵�����
		Integer count=this.menuService.queryMenuByPid(menuVo.getId());
		if(count>0) {
			return ResultObj.STATUS_TRUE;
		}else {
			return ResultObj.STATUS_FALSE;
		}
	}
	
	/**
	 * ɾ���˵�
	 */
	@RequestMapping("deleteMenu")
	public ResultObj deleteMenu(MenuVo menuVo) {
		try {
			this.menuService.deleteMenu(menuVo);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}

}

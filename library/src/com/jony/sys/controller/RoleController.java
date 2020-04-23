package com.jony.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jony.sys.service.RoleService;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.utils.ResultObj;
import com.jony.sys.vo.RoleVo;

/**
 * ��ɫ���������
 * 
 * @author LJH
 *
 */
@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	/**
	 * ���ؽ�ɫ�б���DataGridView
	 */
	@RequestMapping("loadAllRole")
	public DataGridView loadAllRole(RoleVo roleVo) {
		return this.roleService.queryAllRole(roleVo);
	}
	
	
	/**
	 * ��ӽ�ɫ
	 */
	@RequestMapping("addRole")
	public ResultObj addRole(RoleVo roleVo) {
		try {
			this.roleService.addRole(roleVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	
	/**
	 * �޸Ľ�ɫ
	 */
	@RequestMapping("updateRole")
	public ResultObj updateRole(RoleVo roleVo) {
		try {
			this.roleService.updateRole(roleVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
	
	
	/**
	 * ɾ����ɫ
	 */
	@RequestMapping("deleteRole")
	public ResultObj deleteRole(RoleVo roleVo) {
		try {
			this.roleService.deleteRole(roleVo.getRoleid());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	
	/**
	 * ����ɾ����ɫ
	 */
	@RequestMapping("deleteBatchRole")
	public ResultObj deleteBatchRole(RoleVo roleVo) {
		try {
			this.roleService.deleteBatchRole(roleVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	
	/*
	 * ���ؽ�ɫ�������˵���json
	 */
	@RequestMapping("initRoleMenuTreeJson")
	public DataGridView initRoleMenuTreeJson(Integer roleid) {
		return this.roleService.initRoleMenuTreeJson(roleid);
	}
	
	/*
	 * �����ɫ�Ͳ˵��Ĺ�ϵ
	 */
	@RequestMapping("saveRoleMenu")
	public ResultObj saveRoleMenu(RoleVo roleVo) {
		try {
			
			this.roleService.saveRoleMenu(roleVo);
			return ResultObj.DISPATCH_SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DISPATCH_ERROR;
		}
		
	}
	
}

package com.jony.sys.service;


import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.RoleVo;


public interface RoleService {
	
	public DataGridView queryAllRole(RoleVo roleVo);
	
	/*
	 * 添加角色
	 */
	public void addRole(RoleVo roleVo);
	
	/*
	 * 修改角色
	 */
	public void updateRole(RoleVo roleVo);
	
	/*
	 * 根据id删除角色
	 */
	public void deleteRole(Integer roleid);
	
	/*
	 * 批量删除角色
	 */
	public void deleteBatchRole(Integer []ids );
	
	/*
	 * 加载角色分配菜单的json
	 */
	public DataGridView initRoleMenuTreeJson(Integer roleid);
	
	/*
	 * 保存角色和菜单的关系
	 */
	public void saveRoleMenu(RoleVo roleVo);

}

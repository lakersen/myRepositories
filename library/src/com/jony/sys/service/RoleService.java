package com.jony.sys.service;


import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.RoleVo;


public interface RoleService {
	
	public DataGridView queryAllRole(RoleVo roleVo);
	
	/*
	 * ��ӽ�ɫ
	 */
	public void addRole(RoleVo roleVo);
	
	/*
	 * �޸Ľ�ɫ
	 */
	public void updateRole(RoleVo roleVo);
	
	/*
	 * ����idɾ����ɫ
	 */
	public void deleteRole(Integer roleid);
	
	/*
	 * ����ɾ����ɫ
	 */
	public void deleteBatchRole(Integer []ids );
	
	/*
	 * ���ؽ�ɫ����˵���json
	 */
	public DataGridView initRoleMenuTreeJson(Integer roleid);
	
	/*
	 * �����ɫ�Ͳ˵��Ĺ�ϵ
	 */
	public void saveRoleMenu(RoleVo roleVo);

}

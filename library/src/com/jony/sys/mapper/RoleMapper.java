package com.jony.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jony.sys.domain.Role;

public interface RoleMapper {
	int deleteByPrimaryKey(Integer roleid);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(Integer roleid);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	/**
	 * ��ѯ��ɫ
	 */
	List<Role> queryAllRole(Role role);

	/**
	 * ���ݽ�ɫidɾ��sys_role_role���������
	 * 
	 * @param roleid
	 */
	void deleteRolMenuByRid(Integer roleid);

	/**
	 * ���ݽ�ɫidɾ��sys_role_user���������
	 * 
	 * @param roleid
	 */
	void deleteRoleUserByRid(Integer roleid);

	/**
	 * �����ɫ�Ͳ˵��Ĺ�ϵ sys_role_menu
	 * @param rid
	 * @param mid
	 */
	void insertRoleMenu(@Param("rid")Integer rid, @Param("mid")Integer mid);
	

	/**
	 * �����û�idɾ��sys_role_user���������
	 * 
	 * @param userid
	 */
	void deleteRoleUserByUid(Integer userid);

	/**
	 * �����û�ID��ѯ��ɫ
	 * @param available
	 * @param userid
	 * @return
	 */
	List<Role> queryRoleByUid(@Param("available")Integer available, @Param("uid")Integer userid);
	

}
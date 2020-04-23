package com.jony.sys.service;


import com.jony.sys.domain.User;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.UserVo;

public interface UserService {

	User login(UserVo userVo);
	/**
	 * ��ѯ�����û�
	 * @param userVo
	 * @return
	 */
	public DataGridView queryAllUser(UserVo userVo);
	
	/**
	 * ����û�
	 * @param userVo
	 */
	public void addUser(UserVo userVo);

	/**
	 * �޸��û�
	 * @param userVo
	 */
	public void updateUser(UserVo userVo);

	/**
	 * ����idɾ���û�
	 * @param userid
	 */
	public void deleteUser(Integer userid);
	/**
	 * ����ɾ���û�
	 * @param userVo
	 */
	public void deleteBatchUser(Integer [] ids);
	
	/**
	 * ��������
	 * @param userid
	 */
	public void resetUserPwd(Integer userid);
	
	/*
	 * �����û�����ķ����ɫ������
	 */
	DataGridView queryUserRole(Integer userid);
	
	/*
	 * �����û��ͽ�ɫ�Ĺ�ϵ
	 */
	void saveUserRole(UserVo userVo);
	
}

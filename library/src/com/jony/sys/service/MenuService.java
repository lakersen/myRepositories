package com.jony.sys.service;

import java.util.List;

import com.jony.sys.domain.Menu;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.MenuVo;

//�˵�����ķ���ӿ�
public interface MenuService {
	
	//��ѯ���в˵�����
	public List<Menu> queryAllMenuForList(MenuVo menuVo);
	
	//�����û�id��ѯ�û��Ŀ��ò˵�
	public List<Menu> queryMenuByUserIdForList(MenuVo menuVo,Integer userId);
	
	//��ѯ���в˵�
	public DataGridView queryAllMenu(MenuVo menuVo);
	
	/*
	 * ��Ӳ˵�
	 */
	public void addMenu(MenuVo menuVo);
	
	/*
	 * �޸Ĳ˵�
	 */
	public void updateMenu(MenuVo menuVo);
	
	/*
	 * ����pid��ѯ�˵�����
	 */
	public Integer queryMenuByPid(Integer pid);
	
	/*
	 * ����idɾ���˵�
	 */
	public void deleteMenu(MenuVo menuVo);

}

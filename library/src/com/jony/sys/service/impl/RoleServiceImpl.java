package com.jony.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jony.sys.constast.SysConstast;
import com.jony.sys.domain.Menu;
import com.jony.sys.domain.Role;
import com.jony.sys.mapper.MenuMapper;
import com.jony.sys.mapper.RoleMapper;
import com.jony.sys.service.RoleService;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.utils.TreeNode;
import com.jony.sys.vo.RoleVo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public DataGridView queryAllRole(RoleVo roleVo) {
		Page<Object> page = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
		List<Role> data = this.roleMapper.queryAllRole(roleVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addRole(RoleVo roleVo) {
		this.roleMapper.insertSelective(roleVo);

	}

	@Override
	public void updateRole(RoleVo roleVo) {
		this.roleMapper.updateByPrimaryKeySelective(roleVo);

	}

	@Override
	public void deleteRole(Integer roleid) {
		// ɾ����ɫ�������
		this.roleMapper.deleteByPrimaryKey(roleid);
		// ���ݽ�ɫidɾ��sys_role_role���������
		this.roleMapper.deleteRolMenuByRid(roleid);
		// ���ݽ�ɫidɾ��sys_role_user���������
		this.roleMapper.deleteRoleUserByRid(roleid);

	}

	@Override
	public void deleteBatchRole(Integer[] ids) {
		for (Integer rid : ids) {
			deleteRole(rid);
		}
	}

	@Override
	public DataGridView initRoleMenuTreeJson(Integer roleid) {
		// ��ѯ���еĿ��õĲ˵�
		Menu menu = new Menu();
		menu.setAvailable(SysConstast.AVAILABLE_TRUE);
		List<Menu> allMenu = menuMapper.queryAllMenu(menu);
		// ���ݽ�ɫID��ѯ��ǰ��ɫӵ�еĲ˵�
		List<Menu> roleMenu = menuMapper.queryMenuByRoleId(SysConstast.AVAILABLE_TRUE, roleid);

		List<TreeNode> data = new ArrayList<>();
		for (Menu m1 : allMenu) {
			String checkArr = SysConstast.CODE_ZERO + "";
			for (Menu m2 : roleMenu) {
				if (m1.getId() == m2.getId()) {
					checkArr = SysConstast.CODE_ONE + "";
					break;
				}
			}
			Integer id = m1.getId();
			Integer pid = m1.getPid();
			String title = m1.getTitle();
			Boolean spread = m1.getSpread() == SysConstast.SPREAD_TRUE ? true : false;
			data.add(new TreeNode(id, pid, title, spread, checkArr));
		}
		return new DataGridView(data);
	}

	@Override
	public void saveRoleMenu(RoleVo roleVo) {
		Integer rid = roleVo.getRoleid();
		Integer[] mids = roleVo.getIds();
		// ����ridɾ��sys_role_menu������������
		this.roleMapper.deleteRolMenuByRid(rid);
		// �����ɫ�Ͳ˵��Ĺ�ϵ
		for (Integer mid : mids) {
			this.roleMapper.insertRoleMenu(rid, mid);
		}
	}

}

package com.jony.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jony.sys.constast.SysConstast;
import com.jony.sys.domain.Role;
import com.jony.sys.domain.User;
import com.jony.sys.mapper.RoleMapper;
import com.jony.sys.mapper.UserMapper;
import com.jony.sys.service.UserService;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public User login(UserVo userVo) {
		// ��������
		String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
		userVo.setPwd(pwd);
		return userMapper.login(userVo);
	}

	@Override
	public DataGridView queryAllUser(UserVo userVo) {
		Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
		List<User> data = this.userMapper.queryAllUser(userVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addUser(UserVo userVo) {
		// ����Ĭ������
		userVo.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
		// �����û����� ������ͨ�û�type=2
		userVo.setType(SysConstast.USER_TYPE_NORMAL);
		this.userMapper.insertSelective(userVo);

	}

	@Override
	public void updateUser(UserVo userVo) {
		this.userMapper.updateByPrimaryKeySelective(userVo);
	}

	@Override
	public void deleteUser(Integer userid) {
		// ɾ���û�
		this.userMapper.deleteByPrimaryKey(userid);
		// �����û�idɾ��sys_role_user���������
		this.roleMapper.deleteRoleUserByUid(userid);
	}

	@Override
	public void deleteBatchUser(Integer[] ids) {
		for (Integer uid : ids) {
			this.deleteUser(uid);
		}
	}

	@Override
	public void resetUserPwd(Integer userid) {
		User user = new User();
		user.setUserid(userid);
		// ����Ĭ������
		user.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
		// ����
		this.userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public DataGridView queryUserRole(Integer userid) {
		// 1,��ѯ���п��õĽ�ɫ
		Role role = new Role();
		role.setAvailable(SysConstast.AVAILABLE_TRUE);
		List<Role> allRole = this.roleMapper.queryAllRole(role);
		// 2,�����û�ID��ѯ��ӵ�еĽ�ɫ
		List<Role> userRole = this.roleMapper.queryRoleByUid(SysConstast.AVAILABLE_TRUE, userid);

		List<Map<String, Object>> data = new ArrayList<>();
		for (Role r1 : allRole) {
			Boolean LAY_CHECKED = false;
			for (Role r2 : userRole) {
				if (r1.getRoleid() == r2.getRoleid()) {
					LAY_CHECKED = true;
				}
			}
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("roleid", r1.getRoleid());
			map.put("rolename", r1.getRolename());
			map.put("roledesc", r1.getRoledesc());
			map.put("LAY_CHECKED", LAY_CHECKED);
			data.add(map);
		}
		return new DataGridView(data);
	}

	@Override
	public void saveUserRole(UserVo userVo) {
		Integer userid = userVo.getUserid();
		Integer[] roleIds = userVo.getIds();
		// �����û�idɾ��sys_role_user���������
		this.roleMapper.deleteRoleUserByUid(userid);
		// �����ϵ
		if (roleIds != null && roleIds.length > 0) {
			for (Integer rid : roleIds) {
				this.userMapper.insertUserRole(userid, rid);
			}
		}
	}

}

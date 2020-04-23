package com.jony.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys")
public class SysController {

	//��ת�˵�����
	@RequestMapping("toMenuManager")
	public String toMenuManager() {
		return "system/menu/menuManager";
	}
	
	//��ת�˵�������ߵĲ˵���ҳ��
	@RequestMapping("toMenuLeft")
	public String toMenuLeft() {
		return "system/menu/menuLeft";
	}
	
	//��ת�˵������ұߵĲ˵���ҳ��
	@RequestMapping("toMenuRight")
	public String toMenuRight() {
		return "system/menu/menuRight";
	}
	
	//��ת��ɫ����ҳ��
	@RequestMapping("toRoleManager")
	public String toRoleManager() {
		return "system/role/roleManager";
	}
	
	//��ת�û�����ҳ��
	@RequestMapping("toUserManager")
	public String toUserManager() {
		return "system/role/userManager";
	}
	
	//��ת��־����ҳ��
	@RequestMapping("toLogInfoManager")
	public String toLogInfoManager() {
		return "system/logInfo/logInfoManager";
	}
	
	//��ת�������ҳ��
	@RequestMapping("toNewsManager")
	public String toNewsManager() {
		return "system/news/newsManager";
	}
}

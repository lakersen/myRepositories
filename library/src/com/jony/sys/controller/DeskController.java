package com.jony.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//����̨�Ŀ�����
@Controller
@RequestMapping("desk")
public class DeskController {

	//��ת������̨ҳ��
	@RequestMapping("toDeskManager")
	public String toDeskManager() {
		return "system/main/deskManager";
	}
	
}

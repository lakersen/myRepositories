package com.jony.sys.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jony.sys.constast.SysConstast;
import com.jony.sys.domain.User;
import com.jony.sys.service.LogInfoService;
import com.jony.sys.service.UserService;
import com.jony.sys.utils.WebUtils;
import com.jony.sys.vo.LogInfoVo;
import com.jony.sys.vo.UserVo;

//用户登录控制器
@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private LogInfoService logInfoService;
	
	//跳转到登录页面
	@RequestMapping("toLogin")
	public String toLogin() {
		return "system/main/login";
	}
	
	//防止表单重复提交
	@RequestMapping("formMul")
	public String formMul() {
		return "system/main/index";
	}
	
	//登录方法
	@RequestMapping("login")
	public String login (UserVo userVo,Model model) {
		User user =this.userService .login(userVo);
		if (user!=null) {
			//放到session
			WebUtils.getHttpSession().setAttribute("user", user);
			//记录登录日志，向sys_login_log里插入数据
			LogInfoVo logInfoVo=new LogInfoVo();
			logInfoVo.setLogintime(new Date());
			logInfoVo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());
			logInfoVo.setLoginname(user.getRealname()+"-"+user.getLoginname());
			
			logInfoService.addLogInfo(logInfoVo);
			
			return "redirect:/login/formMul.action";
		}else {
			model.addAttribute("error",SysConstast.USER_LOGIN_ERROR_MSG);
			return "system/main/login";
		}
		
	}
}

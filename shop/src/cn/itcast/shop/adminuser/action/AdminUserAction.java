package cn.itcast.shop.adminuser.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import cn.itcast.shop.adminuser.service.AdminUserService;
import cn.itcast.shop.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements
		ModelDriven<AdminUser> {
	// 妯″瀷椹卞姩浣跨敤鐨勫璞�
private AdminUser adminUser = new AdminUser();


public AdminUser getModel() {
		return adminUser;
	                  }

	// 娉ㄥ叆AdminUserService
	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	// 鍚庡彴鐧诲綍鐨勬墽琛岀殑鏂规硶
	public String login() {
		// 璋冪敤service鏂规硶瀹屾垚鐧诲綍
		AdminUser existAdminUser = adminUserService.login(adminUser);
		// 鍒ゆ柇
		if (existAdminUser == null) {
			// 鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒
			this.addActionError("鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒!");
			return "loginFail";
		} else {
			// 鐧诲綍鎴愬姛:
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}
}

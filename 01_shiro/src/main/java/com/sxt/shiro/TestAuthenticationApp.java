package com.sxt.shiro;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SuppressWarnings("deprecation")
public class TestAuthenticationApp {
int a=55;
int p=445;
	private static final transient Logger log=LoggerFactory.getLogger(TestAuthenticationApp.class);
	public static void main(String[] args) {
		String username="zhangsan";
		String password="123456";
		
		log.info("My First Apache Shiro Application");
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
				SecurityManager securityManager=factory.getInstance();
				SecurityUtils.setSecurityManager(securityManager);
			        Subject subject = SecurityUtils.getSubject();
			        AuthenticationToken token = new UsernamePasswordToken(username,password);
			        try {
						subject.login(token);
						System.out.println("认证通过");
					} catch (AuthenticationException e) {
						System.out.println("用户名密码不正确");
						// TODO: handle exception
					}
			        
			            Subject subject2 = SecurityUtils.getSubject();
			            System.out.println(subject);
			            System.out.println(subject2);
			            aaaa();
	}
	
	public static void aaaa() {
		Subject subject2 = SecurityUtils.getSubject();
		System.out.println(subject2);
	}
}

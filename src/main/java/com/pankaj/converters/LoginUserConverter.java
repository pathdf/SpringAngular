package com.pankaj.converters;

import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.pankaj.bean.LoginUserBean;
import com.pankaj.model.LoginUser;

public class LoginUserConverter {

	public static LoginUser getEntityBeanFromUIBean(LoginUserBean userBean){
		LoginUser user = null;
		if(userBean != null){
			user = new LoginUser();
			user.setUserName(userBean.getUserName());
			user.setPassword(userBean.getPassword());
		}
		return user;
		
	}
	
	public static LoginUserBean getUIBeanFromEntityBean(LoginUser user){
		LoginUserBean userBean= null;
		if(user != null){
			userBean = new LoginUserBean();
			userBean.setMaxTries(user.getMaxTries());
		}
		return userBean;
	}
}

package com.pankaj.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.bean.LoginUserBean;
import com.pankaj.converters.LoginUserConverter;
import com.pankaj.model.LoginUser;
import com.pankaj.service.LoginService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@Transactional
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/api/login", method=RequestMethod.POST)
	public LoginUserBean loginUser(@RequestBody LoginUserBean userBean){
		LoginUserBean userBeanResponse =null;
		if(userBean!=null && !StringUtils.isBlank(userBean.getUserName())){
			
			LoginUser user = loginService.getUser(userBean.getUserName(), userBean.getPassword());
			userBeanResponse = LoginUserConverter.getUIBeanFromEntityBean(user);
			if(user != null && user.getMaxTries()<3){
				user.setLastLoginDate(new Date());
				loginService.update(user);
				return userBeanResponse;
			}else if(user != null && user.getMaxTries()>2){
				userBeanResponse.setLoginStatus(false);
				return userBeanResponse;
			}
			user = loginService.getUser(userBean.getUserName());
			userBeanResponse = LoginUserConverter.getUIBeanFromEntityBean(user);
			if(user != null){
				if(user.getMaxTries()>2){
					userBeanResponse.setLoginStatus(false);
					return userBeanResponse;
				}
				user.setMaxTries(user.getMaxTries()+1);
				userBeanResponse.setMaxTries(user.getMaxTries());
				if(user.getMaxTries()>2){
					user.setStatus("In-Active");
				}
				userBeanResponse.setLoginStatus(false);
				loginService.update(user);
			}			
			
		}
		
		
		return userBeanResponse;
	}
}

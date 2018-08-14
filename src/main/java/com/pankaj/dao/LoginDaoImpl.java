package com.pankaj.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pankaj.model.LoginUser;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public LoginUser getUser(String userName, String password) {
		String HQL = "SELECT user FROM LoginUser user WHERE user.userName = :userName AND user.password = :password";
		return (LoginUser)sessionFactory.getCurrentSession().createQuery(HQL).setParameter("userName", userName).setParameter("password", password).uniqueResult();
	}

	public void update(LoginUser user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public LoginUser getUser(String userName) {
		String HQL = "SELECT user FROM LoginUser user WHERE user.userName = :userName";
		return (LoginUser)sessionFactory.getCurrentSession().createQuery(HQL).setParameter("userName", userName).uniqueResult();
		
	}
	
	
	
}

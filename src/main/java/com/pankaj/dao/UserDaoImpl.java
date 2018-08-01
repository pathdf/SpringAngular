package com.pankaj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pankaj.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public User getUserById(Long id) {
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
		
	}

	
	public User saveOrUpdateUser(User user) {
		 sessionFactory.getCurrentSession().saveOrUpdate(user);
		 return null;
	}

	
	public List<User> getAllUser() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	
	public User deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		if(user.getId()!=null){
			return (User)sessionFactory.getCurrentSession().get(User.class, user.getId());
		}
		return null;
	}

}

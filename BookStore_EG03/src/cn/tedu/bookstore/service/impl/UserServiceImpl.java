package cn.tedu.bookstore.service.impl;

import cn.tedu.bookstore.bean.User;
import cn.tedu.bookstore.dao.UserDao;
import cn.tedu.bookstore.dao.impl.UserDaoImpl;
import cn.tedu.bookstore.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao dao=new UserDaoImpl();
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return dao.getUser(user);
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	@Override
	public boolean checkName(String username) {
		// TODO Auto-generated method stub
		User user=dao.checkName(username);
		return user==null;
	}

}

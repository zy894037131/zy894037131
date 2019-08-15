package cn.tedu.bookstore.dao.impl;

import cn.tedu.bookstore.bean.User;
import cn.tedu.bookstore.dao.BaseDao;
import cn.tedu.bookstore.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		String sql="insert into bs_user (id,username,password,email) values (?,?,?,?)";
		try {
			int	i=update(sql, user.getId(),user.getUsername(),user.getPassword(),user.getEmail());
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		String sql="select * from bs_user where username=? and password=?";
		return getBean(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public User checkName(String name) {
		// TODO Auto-generated method stub
		String sql="select *  from bs_user where username=?";
		User bean = getBean(sql, name);
		return bean;
	}

}

package cn.tedu.bookstore.dao;

import cn.tedu.bookstore.bean.User;

public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * 得到
	 * @param user
	 * @return
	 */
	User getUser(User user);
	User checkName(String name);
}

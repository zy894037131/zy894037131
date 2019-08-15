package cn.tedu.bookstore.service;

import cn.tedu.bookstore.bean.User;

public interface UserService {
	/**
	 * 得到用户
	 * @param user
	 * @return
	 */
	User getUser(User user);
	
	int saveUser(User user);
	boolean checkName(String username);
}

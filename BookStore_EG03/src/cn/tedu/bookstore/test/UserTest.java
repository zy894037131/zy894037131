package cn.tedu.bookstore.test;

import org.junit.Test;

import cn.tedu.bookstore.bean.User;
import cn.tedu.bookstore.dao.impl.UserDaoImpl;

public class UserTest {
	@Test
	public void test1(){
		UserDaoImpl udi=new UserDaoImpl();
		int i=udi.addUser(new User(null, "Tom", "123456", "123456@qq.com"));
		System.out.println(i);
	}
	@Test
	public void test2(){
		UserDaoImpl udi=new UserDaoImpl();
		String sql="select * from bs_user where username=? and password=?";
		User user=udi.getUser(new User(null, "Tom", "123456", null));
		System.out.println(user);
	}
}

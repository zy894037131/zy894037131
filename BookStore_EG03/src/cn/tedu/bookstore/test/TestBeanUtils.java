package cn.tedu.bookstore.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import cn.tedu.bookstore.bean.User;
import cn.tedu.bookstore.dao.UserDao;

public class TestBeanUtils {
	/**
	 * BeanUtils第三方jar包
	 * 	》可以将一个集合中的数据设置给一个对象[一个有数据的集合，一个空的对象，集合中的存数据的key要和对象的属性名一样]
	 * 	》可以将一个对象转为一个集合
	 * 	1、导包
	 */
	@Test
	public void test() {
		//1、有数据的集合
		Map map = new HashMap();
		map.put("id", 1234);
		map.put("username", "wangyongchao1");
		map.put("password", "123456");
		
		//2、空对象
		cn.tedu.bookstore.bean.User user = new cn.tedu.bookstore.bean.User();
		System.out.println(user);
		//3、调用BeanUtils的方法
		//参数1：空的对象 ，参数2：有数据的集合  数据源
		try {
			//LogFactory类找不到异常   BeanUtils有一个依赖包logging包
			//beanUtils根据反射找到getSet方法 设置属性值和读取属性值
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user);
	}
	@Test
	public void test1() {
		//将一个对象封装到集合中
		User user = new User(1, "laowang", "yongchao", "laowang@126.com");
		try {
			// bean的属性名作为key，属性值作为value存到map中
			Map map = BeanUtils.describe(user);
			System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}

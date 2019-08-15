package cn.tedu.bookstore.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.tedu.bookstore.bean.Book;
import cn.tedu.bookstore.bean.CartItem;
import cn.tedu.bookstore.bean.Order;
import cn.tedu.bookstore.bean.OrderItem;
import cn.tedu.bookstore.bean.ShoppingCart;
import cn.tedu.bookstore.bean.User;
import cn.tedu.bookstore.dao.OrderDao;
import cn.tedu.bookstore.dao.OrderItemDao;
import cn.tedu.bookstore.dao.impl.OrderDaoImpl;
import cn.tedu.bookstore.dao.impl.OrderItemDaoImpl;

public class OrderTest {
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	@Test
	public void test1(){
		// 1、判断用户是否登录
				// 2、如果登录，在servlet中获取购物车对象，获取用户对象
				ShoppingCart cart = new ShoppingCart();
				Book b1 = new Book(1, "ios从入门到转行", "陈显东",10,  0, 1000,"/static/img/default.jpg");
				Book b2 = new Book(2, "android从入门到转行", "陈筵席",  10, 0, 1000,"/static/img/default.jpg");
				Book b3 = new Book(4, "java从入门到转行", "阳光浴",  10, 0, 1000,"/static/img/default.jpg");
				cart.add2ShoppingCart(b1);
				cart.add2ShoppingCart(b1);
				cart.add2ShoppingCart(b1);
				cart.add2ShoppingCart(b2);
				cart.add2ShoppingCart(b2);
				cart.add2ShoppingCart(b3);
				User user = new User(8, "LuXi", "111111", "11@qq.com");
				// 在Servlet中调用OrderService中的createOrder方法处理业务
				// 3、调用orderService：将购物车转为订单，购物项转为订单项
				// 3.1将购物车转为订单
				// 创建订单id 时间戳+userId
				String id = System.currentTimeMillis() + "" + user.getId();
				// 创建订单默认状态 默认为0未发货
				int state = 0;
				// 当前时间就是订单创建时间 Date使用util包下的
				Date orderTime = new Date();
				System.out.println(cart.getTotalBookPrice());
				Order order = new Order(id, cart.getTotalBookCount(), cart.getTotalBookPrice(), state, orderTime, user.getId());
				// 3.2将购物车的购物项转为订单项
				List<CartItem> list = cart.getCartItemList();
				// 4、调用OrderDao和OrderItemDao将数据保存到数据库
				// 调用OrderDao将订单保存到数据库
				System.out.println(orderDao.saveOrder(order));
				// 每一个购物项对应一个订单项对象
				for (CartItem cartItem : list) {
					Book book = cartItem.getBook();
					OrderItem orderItem = new OrderItem(null, book.getTitle(), book.getAuthot(), book.getImgPath(), book.getPrice(),
							cartItem.getTotalCount(), cartItem.getTotalPrice(), id);
					System.out.println(orderItemDao.saveOrderItem(orderItem));
				}
	}
}

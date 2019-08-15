package cn.tedu.bookstore.service;

import java.util.List;

import cn.tedu.bookstore.bean.Order;
import cn.tedu.bookstore.bean.ShoppingCart;
import cn.tedu.bookstore.bean.User;

public interface OrderService {
	/*
	 * 保存订单
	 */
	String saveOrder(ShoppingCart cart,User user);
	/*
	 * 通过人员id得到订单
	 */
	List<Order> getOrderListByUserId(Integer userId);
	/*
	 * 管理员得到所有订单列表
	 */
	List<Order> getOrderList();
	/*
	 * 修改定安状态
	 */
	boolean updateOrderState(String orderId,Integer state);
}

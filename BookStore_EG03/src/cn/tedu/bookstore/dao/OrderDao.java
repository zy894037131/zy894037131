package cn.tedu.bookstore.dao;

import java.util.List;

import cn.tedu.bookstore.bean.Order;

public interface OrderDao {
	/*
	 * 保存订单
	 */
	int saveOrder(Order order);
	/*
	 * 根据人员id获得订单列表
	 */
	List<Order> getOrderListByUserId(int userId);
	/*
	 * 获得或有订单
	 */
	List<Order> getOrderList();
	/*
	 * 修改订单状态
	 */
	int updateState(String orderId,int state);
}

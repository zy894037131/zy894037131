package cn.tedu.bookstore.dao;

import java.util.List;

import cn.tedu.bookstore.bean.OrderItem;

public interface OrderItemDao {
	/*
	 * 保存订单项
	 */
	int saveOrderItem(OrderItem orderItem);
	/*
	 * 通过订单id得到订单项id
	 */
	List<OrderItem> getOrderItemByOrderId(String OrderId);
	
	
}

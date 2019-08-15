package cn.tedu.bookstore.dao.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import cn.tedu.bookstore.bean.Order;
import cn.tedu.bookstore.dao.BaseDao;
import cn.tedu.bookstore.dao.OrderDao;
import sun.security.jca.GetInstance.Instance;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao{

	@Override
	public int saveOrder(Order order) {
		// TODO Auto-generated method stub
		String sql="insert into bs_order (id,total_count,total_amount,state,order_time,user_id) values(?,?,?,?,?,?)";
		int update = update(sql, order.getId(),order.getTotalCount(),order.getTotalAmount(),order.getState(),order.getDateTime(),order.getUserId());
		return update;
	}

	@Override
	public List<Order> getOrderListByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql="select id,total_count totalCount,total_amount totalAmount,state,order_time dateTime,user_id userId from bs_order where user_id=?";
		return getListBean(sql, userId);
	}

	@Override
	public List<Order> getOrderList() {
		// TODO Auto-generated method stub
		String sql="select id,total_count totalCount,total_amount totalAmount,state,order_time dateTime,user_id userId from bs_order ";
		return getListBean(sql);
	}

	@Override
	public int updateState(String orderId, int state) {
		// TODO Auto-generated method stub
		String sql="update bs_order set state=? where id=?";
		return update(sql, state,orderId);
	}

}

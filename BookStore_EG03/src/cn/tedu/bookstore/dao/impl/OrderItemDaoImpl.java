package cn.tedu.bookstore.dao.impl;

import java.util.List;

import cn.tedu.bookstore.bean.OrderItem;
import cn.tedu.bookstore.dao.BaseDao;
import cn.tedu.bookstore.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao{

	@Override
	public int saveOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		String sql="insert into bs_orderitem (title,author,img_path,price,count,amount,order_id) values(?,?,?,?,?,?,?)";
		int update = update(sql, orderItem.getTitle(),orderItem.getAuthor(),orderItem.getImgPath(),orderItem.getPrice(),orderItem.getCount(),orderItem.getAmount(),orderItem.getOrderId());
		return update;
	}

	@Override
	public List<OrderItem> getOrderItemByOrderId(String OrderId) {
		// TODO Auto-generated method stub
		String sql="select id ,title,author,img_path imgPath,price,count,amount,order_id orderId from bs_orderitem where order_id=?";
		return getListBean(sql, OrderId);
	}

}

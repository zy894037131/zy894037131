package cn.tedu.bookstore.service.impl;

import java.util.Date;
import java.util.List;

import cn.tedu.bookstore.bean.Book;
import cn.tedu.bookstore.bean.CartItem;
import cn.tedu.bookstore.bean.Order;
import cn.tedu.bookstore.bean.OrderItem;
import cn.tedu.bookstore.bean.ShoppingCart;
import cn.tedu.bookstore.bean.User;
import cn.tedu.bookstore.dao.BookDao;
import cn.tedu.bookstore.dao.OrderDao;
import cn.tedu.bookstore.dao.OrderItemDao;
import cn.tedu.bookstore.dao.impl.BookDaoImpl;
import cn.tedu.bookstore.dao.impl.OrderDaoImpl;
import cn.tedu.bookstore.dao.impl.OrderItemDaoImpl;
import cn.tedu.bookstore.service.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDao od=new OrderDaoImpl();
	private OrderItemDao oid=new OrderItemDaoImpl();
	private BookDao bd=new BookDaoImpl();
	@Override
	public String saveOrder(ShoppingCart cart, User user) {
		// TODO Auto-generated method stub
//		int order=0;
//		int orderItem=0;
		String orderId=System.currentTimeMillis()+""+user.getId();
		Date dateTime=new Date();
		List<CartItem> item=cart.getCartItemList();
		Object[][] param1=new Object[item.size()][];
		Object[][] param2=new Object[item.size()][];
		//保存订单项
		od.saveOrder(new Order(orderId, cart.getTotalBookCount(), cart.getTotalBookPrice(), 0, dateTime, user.getId()));
		int i=0;
		for(CartItem c:item){
			//循环保存明细
			//oid.saveOrderItem(new OrderItem(null, c.getBook().getTitle(), c.getBook().getAuthot(), c.getBook().getImgPath(), c.getBook().getPrice(), c.getTotalCount(), c.getTotalPrice(), orderId));
			param1[i]=new Object[]{c.getBook().getTitle(),c.getBook().getAuthot(),c.getBook().getImgPath(),c.getBook().getPrice(),c.getTotalCount(),c.getTotalPrice(),orderId};
			//计算库存量
			int stock=c.getBook().getStock()-c.getTotalCount();
			//防止购买数量超出库存
			if(stock<0){
				throw new RuntimeException("购买图书超出库存不可提交");
			}
			//计算销量
			int sales=c.getBook().getSales()+c.getTotalCount();
			Book book=c.getBook();
			//修改对象
//			book.setSales(sales);
//			book.setStock(stock);
			//通过对象修改数据库
			//bd.updateBook(book);
			param2[i]=new Object[]{sales,stock,book.getId()};
			i++;
		}
		bd.batchInserOrderDetail(param1);
		bd.batchUpdateBookPriceAndStoke(param2);
		return orderId;
	}
	@Override
	public List<Order> getOrderListByUserId(Integer userId) {
		// TODO Auto-generated method stub
		
		List<Order> orderListByUserId = od.getOrderListByUserId(userId);
		return orderListByUserId;
	}
	@Override
	public List<Order> getOrderList() {
		// TODO Auto-generated method stub
		List<Order> orderList = od.getOrderList();
		return orderList;	
		}
	@Override
	public boolean updateOrderState(String orderId, Integer state) {
		// TODO Auto-generated method stub
		
		return od.updateState(orderId, state)>0;
	}

}

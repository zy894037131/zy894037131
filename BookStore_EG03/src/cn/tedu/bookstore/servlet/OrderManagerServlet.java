package cn.tedu.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.bookstore.bean.Order;
import cn.tedu.bookstore.service.OrderService;
import cn.tedu.bookstore.service.impl.OrderServiceImpl;

public class OrderManagerServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderService os=new OrderServiceImpl();
	/*
	 * 管理员查看所有订单
	 */
	public void getOrderAll(HttpServletRequest request,HttpServletResponse response){
		List<Order> orderList = os.getOrderList();
		request.setAttribute("allOrder", orderList);
		try {
			request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	/*
	 * 管理员发货
	 */
	public void updateOrderState(HttpServletRequest request,HttpServletResponse response){
		String orderId=request.getParameter("orderId");
		if(orderId!=null){
			boolean updateOrderState = os.updateOrderState(orderId, 1);
			if(updateOrderState){
				try {
					response.sendRedirect(request.getHeader("referer"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

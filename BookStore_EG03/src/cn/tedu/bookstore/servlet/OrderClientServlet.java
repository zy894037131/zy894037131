package cn.tedu.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.bookstore.bean.Order;
import cn.tedu.bookstore.bean.ShoppingCart;
import cn.tedu.bookstore.bean.User;
import cn.tedu.bookstore.service.OrderService;
import cn.tedu.bookstore.service.impl.OrderServiceImpl;

public class OrderClientServlet extends BaseServlet{
	private OrderService os=new OrderServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 保存订单
	 */
	public void saveOrder(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		//判断是否登录
		User user = (User) session.getAttribute("user");
		//if(user!=null){
			ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
			String orderId = os.saveOrder(cart, user);
			request.setAttribute("orderId", orderId);
			//提交订单后清空购物车
			cart.getMap().clear();
			try {
				request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}else{
//			//设置登录失败提示信息
//			request.setAttribute("errMsg", "提交订单前请登录！！！");
//			//登录失败转发回登录页面
//			try {
//				request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
//			} catch (ServletException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
	/*
	 * 用户查看订单
	 */
	public void UserGetOrderList(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		//判断是否登录
		User user = (User) session.getAttribute("user");
		//if(user!=null){
			List<Order> orderListByUserId = os.getOrderListByUserId(user.getId());
			request.setAttribute("order", orderListByUserId);
			try {
				request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}else{
//			//设置登录失败提示信息
//			request.setAttribute("errMsg", "查看订单请登录！！！");
//			//登录失败转发回登录页面
//			try {
//				request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
//			} catch (ServletException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
	/*
	 * 客户端确认收货
	 */
	public void updateOrderState(HttpServletRequest request,HttpServletResponse response){
		String orderId=request.getParameter("orderId");
		if(orderId!=null){
			boolean updateOrderState = os.updateOrderState(orderId, 3);
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

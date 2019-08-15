package cn.tedu.bookstore.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cn.tedu.bookstore.bean.Book;
import cn.tedu.bookstore.bean.CartItem;
import cn.tedu.bookstore.bean.ShoppingCart;
import cn.tedu.bookstore.service.BookService;
import cn.tedu.bookstore.service.impl.BookServiceImpl;

public class CartServlet extends BaseServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BookService bs=new BookServiceImpl();
	/*
	 * 添加到购物车
	 */
	public void add2Cart(HttpServletRequest request,HttpServletResponse response){
		String bookId=request.getParameter("bookId");
		Book book=bs.getBookById(bookId);
		HttpSession session = request.getSession();
		ShoppingCart  bc= (ShoppingCart) session.getAttribute("cart");
		if(bc==null){
			bc=new ShoppingCart();
			session.setAttribute("cart", bc);
		}
		bc.add2ShoppingCart(book);
		session.setAttribute("title", book.getTitle());
		System.out.println("加入购物车"+bc);
		Map m=new HashMap<>();
		m.put("totalNum", bc.getTotalBookCount());
		m.put("bookName", book.getTitle());
		Gson gson=new Gson();
		String jsonStr=gson.toJson(m);
		try {
			response.getWriter().write(jsonStr);
			//response.sendRedirect(request.getHeader("referer"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 清空购物车
	 */
	public void clearCart(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		//可能因时间过长失效
		if(cart!=null){
			cart.getMap().clear();
			System.out.println("购物车"+cart);
		}
		try {
			response.sendRedirect(request.getHeader("referer"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 删除购物车一本书
	 */
	public void delBook(HttpServletRequest request,HttpServletResponse response){
		String bookid=request.getParameter("bookId");
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if(cart!=null){
			cart.delOneCartItem(bookid);
		}
		try {
			response.sendRedirect(request.getHeader("referer"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 修改图书数量
	 */
	public void updateCount(HttpServletRequest request,HttpServletResponse response){
		String bookId=request.getParameter("bookId");
		String totalCount=request.getParameter("totalCount");
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if(cart!=null){
			cart.updateCartItem(bookId, totalCount);
		}
		try {
			CartItem item=cart.getMap().get(bookId);
			Map<String, Object> m=new HashMap<String,Object>();
			m.put("totalBookPrice", cart.getTotalBookPrice());
			m.put("totalBookCount", cart.getTotalBookCount());
			m.put("totalPrice", item.getTotalPrice());
			Gson gson=new Gson();
			String gStr=gson.toJson(m);
			response.getWriter().write(gStr);
			//response.sendRedirect(request.getHeader("referer"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

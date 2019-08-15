package cn.tedu.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.bookstore.bean.Page;
import cn.tedu.bookstore.service.BookService;
import cn.tedu.bookstore.service.impl.BookServiceImpl;
import cn.tedu.bookstore.utils.WebUtils;

public class BookClientServlet extends BaseServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BookService bs=new BookServiceImpl();
	/*
	 * 得到客户端首页分页产品展示
	 */
	public void getPageIndex(HttpServletRequest request,HttpServletResponse response){
		int pageNumber=1;
		 try {
			pageNumber=Integer.valueOf(request.getParameter("pageNumber"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int size=4;
		Page page=bs.getPage(pageNumber, size);
		String pageURL = WebUtils.getPageURL(request, response);
		page.setPath(pageURL);
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/pages/list/list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 得到按价格查询的分页
	 */
	public void getPageIndexByPrice(HttpServletRequest request,HttpServletResponse response){
		String min=request.getParameter("min");
		String max=request.getParameter("max");
		String pageNumber=request.getParameter("pageNumber");
		int size=4;
		Page pageByPrice = bs.getPageByPrice(pageNumber, size, min, max);
		String pageURL = WebUtils.getPageURL(request, response);
		pageByPrice.setPath(pageURL);
		request.setAttribute("page", pageByPrice);
		try {
			request.getRequestDispatcher("/pages/list/list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

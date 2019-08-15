package cn.tedu.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.tedu.bookstore.bean.Book;
import cn.tedu.bookstore.bean.Page;
import cn.tedu.bookstore.service.BookService;
import cn.tedu.bookstore.service.impl.BookServiceImpl;
import cn.tedu.bookstore.utils.WebUtils;

public class ManagerBookServlet extends BaseServlet{
	BookService bs=new BookServiceImpl();
	 /*
	  * 得到全部图书进行展示
	  */
	public void getAllBook(HttpServletRequest request,HttpServletResponse response){
		List<Book> listBook = bs.getListBook();
		request.setAttribute("bookList", listBook);
		try {
			request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 删除图书
	 */
	public void delBook(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("bookId");
		bs.delBook(id);
		//得到上一个页面的连接
		String referer=request.getHeader("Referer");
		try {
			/*
			 * 重定向访问删除前页面
			 */
			response.sendRedirect(referer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 添加图书
	 */
	public void addBook(HttpServletRequest request,HttpServletResponse response){
		Book param2Bean = WebUtils.param2Bean(request, new Book());
		param2Bean.setImgPath("/static/img/default.jpg");
		bs.saveBook(param2Bean);
		try {
			response.sendRedirect(request.getContextPath()+"/Manager/ManagerBookServlet?method=getPage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 得到要修改的图书放入修改页面
	 */
	public void getEditBook(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("bookId");
		Book bookById = bs.getBookById(id);
		request.setAttribute("book", bookById);
		String referer=request.getHeader("referer");
		request.setAttribute("referer", referer);
		try {
			request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
		System.out.println("进入修改界面的转发");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 修改图书
	 */
	public void editBook(HttpServletRequest request,HttpServletResponse response){
		Book param2Bean = WebUtils.param2Bean(request, new Book());
		String referer=request.getParameter("referer");
		bs.editBook(param2Bean);
		try {
			response.sendRedirect(referer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 得到图书分页
	 */
	public void getPage(HttpServletRequest request,HttpServletResponse response){
		int pageNumber=1;
		try {
			pageNumber=Integer.valueOf(request.getParameter("pageNumber"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int size=4;
		Page page = bs.getPage(pageNumber, size);
		request.setAttribute("page", page);
		String path=WebUtils.getPageURL(request, response);
		page.setPath(path);
		try {
			request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package cn.tedu.bookstore.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		//获取前台想要调用得方法
		String method =request.getParameter("method");
		//获得子类类对象
		Class<? extends BaseServlet> class1 = this.getClass();
		try {
			//通过反射获取要调用得子类方法
			Method declaredMethod = class1.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//通过反射直接调用，解耦去重复代码每个大功能得servlet只需要写处理方法即可
			declaredMethod.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	

}

package cn.tedu.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.bookstore.bean.User;
import cn.tedu.bookstore.dao.impl.UserDaoImpl;
import cn.tedu.bookstore.service.UserService;
import cn.tedu.bookstore.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet{
	/**
	 * 登录验证
	 */
	private UserService usi=new UserServiceImpl();
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置解析编码格式
		request.setCharacterEncoding("utf-8");
		//通知浏览器解析格式
		response.setContentType("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDaoImpl udi=new UserDaoImpl();
		//调用Dao层校验登录信息
		User bean=usi.getUser(new User(null, username, password, null));
		if(bean==null){
			//设置登录失败提示信息
			request.setAttribute("errMsg", "用户名或密码错误请重新输入");
			//登录失败转发回登录页面
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			//登录成功重定向到登陆成功页面
			response.sendRedirect("/BookStore_EG01/pages/user/login_success.jsp");
		}
	}
	
}

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

public class RegistServlet extends HttpServlet{
	/**
	 * 
	 */
	private UserService usi=new UserServiceImpl();
	private static final long serialVersionUID = 1L;
	/**
	 * 注册
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		UserDaoImpl udi=new UserDaoImpl();
		//调用Dao层保存数据
		int i=usi.saveUser(new User(3, username, password, email));
		if(i==0){
			//提示注册失败信息
			request.setAttribute("errMsg", "注册失败请重新输入");
			//注册失败
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);;
		}else{
			//注册成功
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}
	}
	
	
}

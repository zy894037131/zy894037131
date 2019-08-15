package cn.tedu.bookstore.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.bookstore.bean.User;
import cn.tedu.bookstore.dao.impl.UserDaoImpl;
import cn.tedu.bookstore.service.UserService;
import cn.tedu.bookstore.service.impl.UserServiceImpl;
import cn.tedu.bookstore.utils.WebUtils;

public class UserServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService usi=new UserServiceImpl();
	
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String method=request.getParameter("method");
//		if("regist".equals(method)){
//			//注册servlet调用
//			UserRegist(request,response);
//		}else if("login".equals(method)){
//			//登录servlet调用
//			UserLogin(request,response);
//		}
//	}
	/*
	 * 用戶登陸
	 */
	public void UserLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//设置解析编码格式
		request.setCharacterEncoding("utf-8");
		//通知浏览器解析格式
		response.setContentType("utf-8");
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
		UserDaoImpl udi=new UserDaoImpl();
		//调用Dao层校验登录信息
		User bean=udi.getUser(WebUtils.param2Bean(request, new User()));
		if(bean==null){
			//设置登录失败提示信息
			request.setAttribute("errMsg", "用户名或密码错误请重新输入");
			//登录失败转发回登录页面
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("user", bean);
			//登录成功重定向到登陆成功页面
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}
	/*
	 * 用戶注冊
	 */
	public void UserRegist(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String code=request.getParameter("code");
		HttpSession session = request.getSession();
		//从session中获取图片验证码
		String img_code=(String) session.getAttribute("img_code");
		//从session中移除图片验证码
		session.removeAttribute("img_code");
		if(code!=null&&code.equals(img_code)){
		UserDaoImpl udi=new UserDaoImpl();
		//调用Dao层保存数据
		int i=usi.saveUser(WebUtils.param2Bean(request, new User()));
		if(i==0){
			//提示注册失败信息
			request.setAttribute("errMsg", "注册失败请重新输入");
			//注册失败
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}else{
			//注册成功
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}
		}else{
			//提示验证码输入失败
			request.setAttribute("errMsg", "验证码输入错误");
			//注册失败
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}
	
	/*
	 * 用户注销
	 */
	public void loginOut(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		/*
		 * 让session失效
		 */
		session.invalidate();
		try {
			//重定向到上一个页面
			response.sendRedirect(request.getHeader("referer"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * ajax验证用户名是否可用
	 */
	public void checkName(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		if(username!=null&&!"".equals(username)){
			boolean checkName = usi.checkName(username);
			if(checkName){
				try {
					response.getWriter().write("{\"name\":\"用户名可以使用\"}");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					response.getWriter().write("{\"name\":\"用户名已存在\"}");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			try {
				response.getWriter().write("{\"name\":\"用户名不可为空\"}");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

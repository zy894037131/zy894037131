package cn.tedu.bookstore.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.bookstore.bean.User;

public class LoginFilter extends BaseFilter{
	/*
	 * (non-Javadoc)
	 * 登录过滤器
	 * @see cn.tedu.bookstore.filter.BaseFilter#filterFun(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void filterFun(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//判断是否登录
		User user = (User) session.getAttribute("user");
		if(user==null){
			//设置登录失败提示信息
			request.setAttribute("errMsg", "订单相关请登录！！！");
			//登录失败转发回登录页面
			try {
				request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				chain.doFilter(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

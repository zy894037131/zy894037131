package cn.tedu.bookstore.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter extends BaseFilter{
	/*
	 * (non-Javadoc)
	 * 字符集过滤器
	 * @see cn.tedu.bookstore.filter.BaseFilter#filterFun(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void filterFun(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			chain.doFilter(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

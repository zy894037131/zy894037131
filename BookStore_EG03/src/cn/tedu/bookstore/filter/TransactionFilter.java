package cn.tedu.bookstore.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.bookstore.utils.JDBCUtils;

/**
 * Servlet Filter implementation class TransactionFilter
 */
public class TransactionFilter extends BaseFilter {

	@Override
	public void filterFun(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		// TODO Auto-generated method stub
		Connection con=JDBCUtils.getConnectionByThreadLocal();
		try {
			con.setAutoCommit(false);
			chain.doFilter(request, response);
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
				response.sendRedirect(request.getContextPath()+"/pages/error/error.jsp");
				chain.doFilter(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			JDBCUtils.closeConByThreadLocal();
		}
	}

    

}

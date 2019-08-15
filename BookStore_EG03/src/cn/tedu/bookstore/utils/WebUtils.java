package cn.tedu.bookstore.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	/*
	 * 将request中的参数封装为对象
	 */
	public static <T> T param2Bean(HttpServletRequest request,T t){
		//1、获取map  数据源
				Map<String, String[]> map = request.getParameterMap();
				//2、调用BeanUtils方法将集合封装给t
				try {
					BeanUtils.populate(t, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return t;
	}
	/*
	 * 得到访问分页页面的url
	 */
	public static String getPageURL(HttpServletRequest request ,HttpServletResponse response){
		String url = request.getRequestURI();
		System.out.println(url);
		String param=request.getQueryString();
		System.out.println(param);
		if(param!=null&&param.contains("&pageNumber")){
			param=param.substring(0, param.indexOf("&pageNumber"));
		}
		return url=url+"?"+param;
	}
}

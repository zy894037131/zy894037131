package cn.tedu.bookstore.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	/**
	 * 获得数据源
	 */
	private static DataSource source=new ComboPooledDataSource("webDataSource");
	/*
	 * 将数据库连接对象设置为静态对象，所有请求线程公用一个连接会大大降低效率增加数据库并发,并且连接无法关闭
	 * 应对应每个请求线程设置一个自己的连接对象，且此对象不随连接次数的多少而重新获取。
	 * 方法一:可使用Map<Thread,Connection>
	 * 方法二:可使用ThreadLocal,可将对应Connect放入当前线程的map中保证一对一且唯一
	 */
	//private static Connection con;
	//考虑到并发问题使用线程安全的 ConcurrentHashMap
	private static ConcurrentHashMap<Thread, Connection> map=new ConcurrentHashMap<Thread,Connection>();
	/*
	 * 通过ThreadLocal控制请求线程的一对一
	 */
	private static ThreadLocal<Connection> local=new ThreadLocal<Connection>(); 
	/**
	 * 获得数据库连接
	 * 通过ConcurrentHashMap获取
	 * @return
	 */
	public static Connection getConnection(){
		System.out.println(source);
//		Connection con=null;
//		try {
//			con = source.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(con==null){
//			try {
//				con=source.getConnection();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		Connection connection = map.get(Thread.currentThread());
		if(connection==null){
			Connection con;
			try {
				con = source.getConnection();
				map.put(Thread.currentThread(), con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return map.get(Thread.currentThread());
	}
	/*
	 * 得到数据库连接
	 */
	public static Connection getConnectionByThreadLocal(){
		Connection connection = local.get();
		if(connection==null){
			try {
				Connection con = source.getConnection();
				local.set(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return local.get();
	}
	/**
	 * 关闭数据库连接
	 * @param con
	 */
	public static void releaseConn(/*Connection con*/){
//		if(con!=null){
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		Connection connection = map.get(Thread.currentThread());
		if(connection!=null){
			try {
				connection.close();
				//因为连接关闭但con并不为空所以要移除重新创建，否则无法连接数据库
				map.remove(Thread.currentThread());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void closeConByThreadLocal(){
		Connection connection = local.get();
		if(connection!=null){
			try {
				connection.close();
				local.remove();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

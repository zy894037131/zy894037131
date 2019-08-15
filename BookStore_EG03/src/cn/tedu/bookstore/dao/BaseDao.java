package cn.tedu.bookstore.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.tedu.bookstore.utils.JDBCUtils;

public class BaseDao<T> {
	private QueryRunner qr=new QueryRunner();
	Class<T> type;
	/**
	 * BaseDao是用来继承的不会直接创建对象
	 */
	public BaseDao(){
		Class<? extends BaseDao> clazz=this.getClass();
		//获取带泛型的父类
		ParameterizedType genericSuperclass = (ParameterizedType) clazz.getGenericSuperclass();
		//获得父类泛型的类型
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		type=(Class<T>) actualTypeArguments[0];
	}
	/**
	 * 增删改方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql,Object... params){
		Connection conn=JDBCUtils.getConnectionByThreadLocal();
		System.out.println("Dao update方法:"+conn);
		int update=0;
		try {
			update = qr.update(conn, sql, params);
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
			//return update;
		}finally{
			//JDBCUtils.releaseConn(conn);
		}
		return update;
	}
	/**
	 * 返回查询对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getBean(String sql,Object...params){
		Connection conn=JDBCUtils.getConnectionByThreadLocal();
		System.out.println("Dao 一个对象方法:"+conn);
		T t=null;
		try {
			 t=qr.query(conn, sql, new BeanHandler<>(type), params);
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//JDBCUtils.releaseConn(conn);
		}
		
		return t;
	}
	/**
	 * 返回查询结果结合
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getListBean(String sql,Object...params){
		Connection conn=JDBCUtils.getConnectionByThreadLocal();
		System.out.println("Dao getList方法:"+conn);
		List<T> list=null;
		try {
			list=qr.query(conn, sql, new BeanListHandler<>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//JDBCUtils.releaseConn(conn);
		}
		return list;
	}
	
	public int getCountNumber(String sql,Object...param){
		Connection con=JDBCUtils.getConnectionByThreadLocal();
		System.out.println("Dao 一列方法:"+con);
		long count=0;
		try {
			  count= qr.query(con, sql, new ScalarHandler<>(), param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		return (int)count;
	}
	/*
	 * 添加批处理
	 */
	public void addBatch(String sql,Object[][] param){
		Connection con =JDBCUtils.getConnectionByThreadLocal();
		System.out.println("Dao 批处理方法:"+con);
		//int[] count=0;
		try {
			qr.batch(con, sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			//JDBCUtils.releaseConn(con);
		}
	}
}

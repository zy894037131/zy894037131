package cn.tedu.bookstore.dao;

import java.util.List;

import cn.tedu.bookstore.bean.Book;
import cn.tedu.bookstore.bean.Page;

public interface BookDao {
	/*
	 * 通过id获得一本书
	 */
	Book getBookById(String id);
	/*
	 * 获得所有图书
	 */
	List<Book> getListBook();
	/*
	 * 保存图书
	 */
	int saveBook(Book book);
	/*
	 * 修改图书信息
	 */
	int updateBook(Book book);
	/*
	 * 删除图书
	 */
	int delBook(String id);
	/*
	 * 得到总页数
	 */
	int getCountNumer();
	/*
	 * 得到分页的图书
	 */
	List<Book> getListPage(int index,int size);
	/*
	 * 得到按价格的书总数
	 */
	int getCountNumberByPrice(double min,double max);
	/*
	 * 得到按价格分页的书数
	 */
	List<Book> getListPageByPrice(int index,int size,double min,double max);
	/*
	 * 批量修改图书价格和库存
	 */
	void batchUpdateBookPriceAndStoke(Object[][] param);
	/*
	 * 批量添加购入图书明细
	 */
	void batchInserOrderDetail(Object[][] param);
}

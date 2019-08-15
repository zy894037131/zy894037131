package cn.tedu.bookstore.service;

import java.util.List;

import cn.tedu.bookstore.bean.Book;
import cn.tedu.bookstore.bean.Page;

public interface BookService {
	/*
	 * 保存图书
	 */
	boolean saveBook(Book book);
	/*
	 * 修改图书
	 */
	boolean editBook(Book book);
	/*
	 * 删除图书
	 */
	boolean delBook(String id);
	/*
	 * 获得所有图书
	 */
	List<Book> getListBook();
	/*
	 * 获得一本图书
	 */
	Book getBookById(String id);
	/*
	 * 得到分页对象Page
	 */
	Page getPage(int pageNumber,int size);
	/*
	 * 按价格得到分页对象Page
	 */
	Page getPageByPrice(String pageNumber,int size,String min,String max);
	/*
	 * 批量修改库存
	 */
	void updateBookStock(Object[][]param);
	/*
	 * 批量插入购买明细
	 */
	void batchInsertdetail(Object[][]param);
}

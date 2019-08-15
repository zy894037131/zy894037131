package cn.tedu.bookstore.dao.impl;

import java.util.List;

import cn.tedu.bookstore.bean.Book;
import cn.tedu.bookstore.dao.BaseDao;
import cn.tedu.bookstore.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao{


	@Override
	public List<Book> getListBook() {
		// TODO Auto-generated method stub
		String sql="select id,title,authot,price,sales,stock,img_path imgPath from bs_book ";
		return getListBean(sql);
	}

	@Override
	public int saveBook(Book book) {
		// TODO Auto-generated method stub
		String sql="insert into bs_book (title,authot,price,sales,stock,img_path)values(?,?,?,?,?,?)";
		
		return update(sql, book.getTitle(),book.getAuthot(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
	}

	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		String sql="update bs_book set title=?,authot=?,price=?,sales=?,stock=?,img_path=? where id=?";
		return update(sql, book.getTitle(),book.getAuthot(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
	}

	@Override
	public Book getBookById(String id) {
		String sql="select id,title,authot,price,sales,stock,img_path imgPath from bs_book where id=?";
		return getBean(sql, id);
	}

	@Override
	public int delBook(String id) {
		// TODO Auto-generated method stub
		String sql="delete from bs_book where id=?";
		return update(sql, id);
	}

	@Override
	public int getCountNumer() {
		String sql="select count(*) from bs_book";
		return getCountNumber(sql);
	}

	@Override
	public List<Book> getListPage(int index, int size) {
		String sql="select id,title,authot,price,sales,stock,img_path imgPath from bs_book limit ?,?";
		return getListBean(sql, index,size);
	}

	@Override
	public int getCountNumberByPrice(double min, double max) {
		// TODO Auto-generated method stub
		String sql="select count(*) from bs_book where price>=? and price<=?";
		return getCountNumber(sql, min,max);
	}

	@Override
	public List<Book> getListPageByPrice(int index, int size, double min, double max) {
		// TODO Auto-generated method stub
		String sql="select id,title,authot,price,sales,stock,img_path imgPath from bs_book where price>=? and price<=? limit ?,?";
		return getListBean(sql, min,max,index,size);
	}

	@Override
	public void batchUpdateBookPriceAndStoke(Object[][] param) {
		// TODO Auto-generated method stub
		String sql="update bs_book set sales=?,stock=? where id=?";
		addBatch(sql, param);
	}

	@Override
	public void batchInserOrderDetail(Object[][] param) {
		// TODO Auto-generated method stub
		String sql="1insert into bs_orderitem (title,author,img_path,price,count,amount,order_id) values(?,?,?,?,?,?,?)";
		addBatch(sql, param);
	}

}

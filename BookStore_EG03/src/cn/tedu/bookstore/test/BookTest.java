package cn.tedu.bookstore.test;

import java.util.List;

import org.junit.Test;

import cn.tedu.bookstore.bean.Book;
import cn.tedu.bookstore.dao.impl.BookDaoImpl;
import cn.tedu.bookstore.service.BookService;
import cn.tedu.bookstore.service.impl.BookServiceImpl;

public class BookTest {
	private Book bookById;
	private List<Book> listBook;
	@Test
	public void test1(){
		BookDaoImpl book=new BookDaoImpl();
		book.saveBook(new Book(null, "Java从入门到放弃", "侠铭", 56.5, 5, 50, "/static/img/default.jpg"));
	}
	@Test
	public void test2(){
		BookDaoImpl book=new BookDaoImpl();
		bookById = book.getBookById("1");
		System.out.println(bookById);
	}
	
	@Test
	public void test3(){
		BookDaoImpl book=new BookDaoImpl();
		 listBook = book.getListBook();
		System.out.println(listBook);
	}
	@Test
	public void test4(){
		BookDaoImpl book=new BookDaoImpl();
		int countPage = book.getCountNumer();
		System.out.println(countPage);
	}
	@Test
	public void test5(){
		BookDaoImpl book=new BookDaoImpl();
		List<Book> listPage = book.getListPage(5, 5);
		System.out.println(listPage);
	}
	@Test
	public void test6(){
		BookService bs=new BookServiceImpl();
		System.out.println(bs.getPage(6, 5));
	}
	@Test
	public void test7(){
		BookService bs=new BookServiceImpl();
		System.out.println(bs.getPageByPrice("3", 4,"20", "40"));
	}
}

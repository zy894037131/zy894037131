package cn.tedu.bookstore.test;

import java.math.BigDecimal;

import org.junit.Test;

import cn.tedu.bookstore.bean.Book;
import cn.tedu.bookstore.bean.ShoppingCart;
import cn.tedu.bookstore.service.BookService;
import cn.tedu.bookstore.service.impl.BookServiceImpl;

public class CartTest {
	
	@Test
	public void test1(){
		BookService bs=new BookServiceImpl();
		Book book=bs.getBookById("2");
		ShoppingCart sc=new ShoppingCart();
		sc.add2ShoppingCart(book);
		sc.add2ShoppingCart(book);
		Book book2=bs.getBookById("5");
		sc.add2ShoppingCart(book2);
		sc.add2ShoppingCart(book2);
		sc.add2ShoppingCart(book2);
		sc.add2ShoppingCart(book2);
		System.out.println(sc);
	}
	@Test
	public void test2(){
		double d1=0.1;
		double d2=0.2;
		double d3=0.3;
		BigDecimal bd1=new BigDecimal(d1+"");
		BigDecimal bd2=new BigDecimal(d2+"");
		BigDecimal bd3=new BigDecimal(d3+"");
		BigDecimal add = bd1.add(bd2).add(bd3);
		double doubleValue = add.doubleValue();
		System.out.println(doubleValue); 
	}
}

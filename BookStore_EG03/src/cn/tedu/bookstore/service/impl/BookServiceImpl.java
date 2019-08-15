package cn.tedu.bookstore.service.impl;

import java.util.List;

import cn.tedu.bookstore.bean.Book;
import cn.tedu.bookstore.bean.Page;
import cn.tedu.bookstore.dao.BookDao;
import cn.tedu.bookstore.dao.impl.BookDaoImpl;
import cn.tedu.bookstore.service.BookService;

public class BookServiceImpl implements BookService{
	BookDao bdi=new BookDaoImpl();
	@Override
	public boolean saveBook(Book book) {
		// TODO Auto-generated method stub
		return bdi.saveBook(book)>0;
	}

	@Override
	public boolean editBook(Book book) {
		// TODO Auto-generated method stub
		return bdi.updateBook(book)>0;
	}

	@Override
	public boolean delBook(String id) {
		// TODO Auto-generated method stub
		return bdi.delBook(id)>0;
	}

	@Override
	public List<Book> getListBook() {
		// TODO Auto-generated method stub
		return bdi.getListBook();
	}

	@Override
	public Book getBookById(String id) {
		// TODO Auto-generated method stub
		return bdi.getBookById(id);
	}

	@Override
	public Page getPage(int pageNumber, int size) {
		// TODO Auto-generated method stub
		Page<Book> page=new Page<Book>();
		page.setPageNumer(pageNumber);
		page.setSize(size);
		int countNumer = bdi.getCountNumer();
		page.setTotalCount(countNumer);
		List<Book> listPage = bdi.getListPage(page.getIndex(), size);
		page.setDate(listPage);
		return page;
	}

	@Override
	public Page getPageByPrice(String pageNumber, int size, String min, String max) {
		// TODO Auto-generated method stub
		int iPageNumber=1;
		double minVal=Double.MIN_VALUE;
		double maxVal=Double.MAX_VALUE;
		try {
			 iPageNumber=Integer.parseInt(pageNumber);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			minVal=Double.parseDouble(min);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			maxVal=Double.parseDouble(max);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int countNumberByPrice = bdi.getCountNumberByPrice(minVal, maxVal);
		Page<Book> page=new Page<Book>();
		page.setSize(size);
		page.setTotalCount(countNumberByPrice);
		page.setPageNumer(iPageNumber);
		List<Book> listPageByPrice = bdi.getListPageByPrice(page.getIndex(), size, minVal, maxVal);
		page.setDate(listPageByPrice);
		return page;
	}

	@Override
	public void updateBookStock(Object[][] param) {
		// TODO Auto-generated method stub
		bdi.batchUpdateBookPriceAndStoke(param);
	}

	@Override
	public void batchInsertdetail(Object[][] param) {
		// TODO Auto-generated method stub
		bdi.batchInserOrderDetail(param);
	}
	
	
}

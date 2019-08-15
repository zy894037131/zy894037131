package cn.tedu.bookstore.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 书
	 */
	private Book book;
	/*
	 * 购买书总数量
	 */
	private int totalCount;
	/*
	 * 购买书的总价格
	 */
	private double totalPrice;
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Book book, int totalCount) {
		super();
		this.book = book;
		this.totalCount = totalCount;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/*
	 * 为确保精度通过对象进行转换
	 */
	public double getTotalPrice() {
		BigDecimal bd01 = new BigDecimal(getBook().getPrice()+"");
		BigDecimal bd03 = new BigDecimal(getTotalCount());
		return bd01.multiply(bd03).doubleValue();
	}
//	public void setTotalPrice(double totalPrice) {
//		this.totalPrice = totalPrice;
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + totalCount;
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (totalCount != other.totalCount)
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", totalCount=" + getTotalCount() + ", totalPrice=" + getTotalPrice() + "]";
	}
	
	

}

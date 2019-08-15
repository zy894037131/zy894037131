package cn.tedu.bookstore.bean;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String authot;
	private double price;
	private Integer sales;
	private Integer stock;
	private String imgPath;
	public Book(Integer id, String title, String authot, double price, Integer sales, Integer stock, String imgPath) {
		super();
		this.id = id;
		this.title = title;
		this.authot = authot;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		this.imgPath = imgPath;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthot() {
		return authot;
	}
	public void setAuthot(String authot) {
		this.authot = authot;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authot == null) ? 0 : authot.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgPath == null) ? 0 : imgPath.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (authot == null) {
			if (other.authot != null)
				return false;
		} else if (!authot.equals(other.authot))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imgPath == null) {
			if (other.imgPath != null)
				return false;
		} else if (!imgPath.equals(other.imgPath))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authot=" + authot + ", price=" + price + ", sales=" + sales
				+ ", stock=" + stock + ", imgPath=" + imgPath + "]";
	}
	
	
}

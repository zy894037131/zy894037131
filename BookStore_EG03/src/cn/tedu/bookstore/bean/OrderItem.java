package cn.tedu.bookstore.bean;

import java.io.Serializable;

public class OrderItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 订单先id
	 */
	private Integer id;
	/*
	 * 书名
	 */
	private String title;
	/*
	 * 作者
	 */
	private String author;
	/*
	 * 图片路径
	 */
	private String imgPath;
	/*
	 * 价格
	 */
	private Double price;
	/*
	 * 数量
	 */
	private Integer count;
	/*
	 * 总金额
	 */
	private Double amount;	
	/*
	 * 订单号
	 */
	private String orderId;
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(Integer id, String title, String author, String imgPath, Double price, Integer count,
			Double amount, String orderId) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.imgPath = imgPath;
		this.price = price;
		this.count = count;
		this.amount = amount;
		this.orderId = orderId;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgPath == null) ? 0 : imgPath.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
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
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
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
		return "OrderItem [id=" + id + ", title=" + title + ", author=" + author + ", imgPath=" + imgPath + ", price="
				+ price + ", count=" + count + ", amount=" + amount + ", orderId=" + orderId + "]";
	}
	
	
}

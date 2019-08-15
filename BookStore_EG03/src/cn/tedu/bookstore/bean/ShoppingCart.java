package cn.tedu.bookstore.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class ShoppingCart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 书的map集合，key为bookId,value为购买书的信息
	 */
	private Map<String, CartItem> map=new LinkedHashMap<String, CartItem>();
	/*
	 * 购物车总数量
	 */
	private int totalBookCount;
	/*
	 * 购物车总价格
	 */
	private double totalBookPrice;
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingCart(Map<String, CartItem> map, int totalBookCount, double totalBookPrice) {
		super();
		this.map = map;
		this.totalBookCount = totalBookCount;
		this.totalBookPrice = totalBookPrice;
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public int getTotalBookCount() {
		//会多次调用，防止叠加每次置成0;
		totalBookCount=0;
		List<CartItem> list=getCartItemList();
		for(CartItem c:list){
			totalBookCount+=c.getTotalCount();
		}
		return totalBookCount;
	}
//	public void setTotalBookCount(int totalBookCount) {
//		this.totalBookCount = totalBookCount;
//	}
	public double getTotalBookPrice() {
		totalBookPrice=0;
		BigDecimal bd1 = new BigDecimal(totalBookPrice+"");
		List<CartItem> list=getCartItemList();
		for(CartItem c:list){
			bd1=bd1.add(new BigDecimal(c.getTotalPrice()+""));
		}
		return bd1.doubleValue();
	}
//	public void setTotalBookPrice(double totalBookPrice) {
//		this.totalBookPrice = totalBookPrice;
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + totalBookCount;
		long temp;
		temp = Double.doubleToLongBits(totalBookPrice);
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
		ShoppingCart other = (ShoppingCart) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (totalBookCount != other.totalBookCount)
			return false;
		if (Double.doubleToLongBits(totalBookPrice) != Double.doubleToLongBits(other.totalBookPrice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShoppingCart [map=" + map + ", totalBookCount=" + getTotalBookCount() + ", totalBookPrice=" + getTotalBookPrice()
				+ "]";
	}
	/*
	 * 将map转化为list
	 */
	public List<CartItem> getCartItemList(){
		Collection<CartItem> values = map.values();
		List<CartItem> list = new ArrayList<>(values);
		return list;
	}
	/*
	 * 添加一本书
	 */
	public void add2ShoppingCart(Book book){
		CartItem c=map.get(book.getId()+"");
		if(c==null){
			map.put(book.getId()+"", new CartItem(book, 1));
		}else{
			c.setTotalCount(c.getTotalCount()+1);
		}
	}
	/*
	 * 删除一个书
	 */
	public void delOneCartItem(String bookId){
		map.remove(bookId);
	}
	/*
	 * 修改图书数量
	 */
	public void updateCartItem(String bookId,String totalCount){
		CartItem cartItem = map.get(bookId);
		if(cartItem!=null){
			//为防止转换错误先获取原有数量
			int count=cartItem.getTotalCount();
			try {
				count=Integer.valueOf(totalCount);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cartItem.setTotalCount(count);
		}
	}
}

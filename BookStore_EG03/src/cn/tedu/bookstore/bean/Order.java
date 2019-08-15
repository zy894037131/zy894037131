package cn.tedu.bookstore.bean;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 订单id
	 */
	private String id;
	/*
	 * 总数量
	 */
	private Integer totalCount;
	/*
	 * 总金额
	 */
	private Double totalAmount;
	/*
	 * 订单状态
	 */
	private Integer state;
	/*
	 * 订单时间
	 */
	private Date dateTime;
	/*
	 * 人员id
	 */
	private Integer userId;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, Integer totalCount, Double totalAmount, Integer state, Date dateTime, Integer userId) {
		super();
		this.id = id;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.state = state;
		this.dateTime = dateTime;
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result + ((totalCount == null) ? 0 : totalCount.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Order other = (Order) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		if (totalCount == null) {
			if (other.totalCount != null)
				return false;
		} else if (!totalCount.equals(other.totalCount))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", totalCount=" + totalCount + ", totalAmount=" + totalAmount + ", state=" + state
				+ ", dateTime=" + dateTime + ", userId=" + userId + "]";
	}
	
	
}

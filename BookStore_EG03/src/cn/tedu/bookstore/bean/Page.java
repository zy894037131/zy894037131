package cn.tedu.bookstore.bean;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 展示对象的集合
	 */
	private List<T> date;
	/*
	 * 当前页码
	 */
	private int pageNumer;
	/*
	 * 页面索引 limit index,size
	 */
	private int index;
	/*
	 * 一页多少条
	 */
	private int size;
	/*
	 * 一共多少条
	 */
	private int totalCount;
	/*
	 * 一共多少页
	 */
	private int totalPage;
	/*
	 * 访问路径
	 */
	private String path;
	public Page(List<T> date, int pageNumer, int index, int size, int totalCount, int totalPage,String path) {
		super();
		this.date = date;
		this.pageNumer = pageNumer;
		this.index = index;
		this.size = size;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.path=path;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<T> getDate() {
		return date;
	}
	public void setDate(List<T> date) {
		this.date = date;
	}
	public int getPageNumer() {
		if(pageNumer<1){
			pageNumer=1;
		}else if(pageNumer>getTotalPage()){
			pageNumer=getTotalPage();
		}
		return pageNumer;
	}
	public void setPageNumer(int pageNumer) {
		this.pageNumer = pageNumer;
	}
	public int getIndex() {
		
		return (getPageNumer()-1)*getSize();
	}
//	public void setIndex(int index) {
//		this.index = index;
//	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		if(getTotalCount()%getSize()==0){
			return getTotalCount()/getSize();
		}else{
			//int类型除不尽double转会int
			return getTotalCount()/getSize()+1;
		}
		
	}
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + index;
		result = prime * result + pageNumer;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + size;
		result = prime * result + totalCount;
		result = prime * result + totalPage;
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
		Page other = (Page) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (index != other.index)
			return false;
		if (pageNumer != other.pageNumer)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (size != other.size)
			return false;
		if (totalCount != other.totalCount)
			return false;
		if (totalPage != other.totalPage)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Page [date=" + date + ", pageNumer=" + pageNumer + ", index=" + getIndex() + ", size=" + size
				+ ", totalCount=" + totalCount + ", totalPage=" + getTotalPage() + ",path"+getPath()+"]";
	}
	
	
}

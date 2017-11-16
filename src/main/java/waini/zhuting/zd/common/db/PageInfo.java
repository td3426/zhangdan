package top.rreeff.common.db;

import java.util.List;

public class PageInfo<T> {
	private int pageNo;
	
	private int pageSize;
	
	private int count;
	
	private List<T> datas;
	
	private String msg;
	
	public PageInfo(){
		
	}
	
	public PageInfo(int pageNo, int pageSize, int count, List<T> datas) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.count = count;
		this.datas = datas;
	}
	
	public PageInfo(int pageNo, int pageSize, int count, List<T> datas,String msg) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.count = count;
		this.datas = datas;
		this.msg = msg;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}

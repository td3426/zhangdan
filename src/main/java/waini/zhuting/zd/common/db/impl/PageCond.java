package top.rreeff.common.db.impl;

import top.rreeff.common.db.IPageCond;


public class PageCond implements IPageCond {
	public static final int DEFAULT_PAGE_SIZE = 10;//默认每页显示数量
	private int currentPage;//当前所在页数
	private int pageSize;//每页显示数量
	private int count;//记录总数
	private int totalPage;//查询结果总页数
	private Boolean isCount;//是否要查询总数
	private int size;//当前页记录数

	public PageCond() {
		this(1,DEFAULT_PAGE_SIZE);
	}

	public PageCond(int currentPage, int pageSize) {
		this(currentPage,pageSize,true);
    }
	
	public PageCond(int currentPage, int pageSize,boolean isCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.isCount = isCount;
	}
	

	/**
	 * 获取查询时每页的大小
	 * @return
	 */
	@Override
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * 设置每页的大小
	 * @param paramInt
	 */
	@Override
	public void setPageSize(int paramInt) {
        this.pageSize = paramInt;
	}

	/**
	 * 获取记录总数
	 * @return
	 */
	@Override
	public int getCount() {
		if(this.isCount){
			return this.count;
		}else{
			return -1;
		}
	}

	/**
	 * 设置记录总数
	 * @param paramInt
	 */
	@Override
	public void setCount(int paramInt) {
		int totalPage = paramInt / this.pageSize;
		if(paramInt % this.pageSize != 0){
			totalPage++;
		}
		this.totalPage = totalPage;
        this.count = paramInt;
       
        if(getIsLast()){
			int i = (this.totalPage - 1) * this.pageSize;
			this.size = this.count - i;
		}else{
			this.size =  this.pageSize;
		}
	}

	/**
	 * 获取查询结果的总页数
	 * @return
	 */
	@Override
	public int getTotalPage() {
		int totalPage = this.count/this.pageSize;
		if(this.count%this.pageSize!=0){
			totalPage++;
		}
		return totalPage;
	}

	/**
	 * 设置查询结果的总页数
	 * @param paramInt
	 */
	@Override
	public void setTotalPage(int paramInt) {
		int pageSize = this.count / paramInt;
		if(this.count % paramInt != 0){
			pageSize++;
		}
		this.pageSize = pageSize;
        this.totalPage = paramInt;
	}

	
	/**
	 * 获取当前的页码
	 * @return
	 */
	@Override
	public int getCurrentPage() {
		return this.currentPage;
	}

	/**
	 * 设置当前的页码
	 * @param paramInt
	 */
	@Override
	public void setCurrentPage(int paramInt) {
		this.currentPage = paramInt;

	}
	
	
	/**
	 * 获取是否要查询总数
	 * @return
	 */
	@Override
	public boolean getIsCount() {
		return this.isCount;
	}

	/**
	 * 设置是否要查询总数
	 * @return
	 */
	@Override
	public void setIsCount(boolean paramBoolean) {
		this.isCount = paramBoolean;

	}

	/**
	 * 获取是否是第一页
	 * @return
	 */
	@Override
	public boolean getIsFirst() {
		if(this.currentPage == 1){
			return true;
		}else{
		   return false;
		}
	}
    
	/**
	 * 获取是否是第一页
	 */
	@Override
	public void setIsFirst(boolean paramBoolean) {
		if(paramBoolean){
			this.currentPage = 1;
		}
	}
	
	/**
	 * 获取是否是最后一页信息
	 * @return
	 */
	@Override
	public boolean getIsLast() {
		if(this.currentPage == this.totalPage){
			return true;
		}else{
		   return false;
		}
	}

	/**
	 * 设置是否是最后一页信息
	 * @return
	 */
	@Override
	public void setIsLast(boolean paramBoolean) {
		if(paramBoolean){
			this.currentPage = this.totalPage;
		}

	}

	/**
	 * 获取当前页记录数
	 */
	@Override
	public int getSize() {
	  return this.size;
	}

	/**
	 * 设置当前页记录数
	 */
	@Override
	public void setSize(int paramInt) {
		 this.size = paramInt;
	}

}

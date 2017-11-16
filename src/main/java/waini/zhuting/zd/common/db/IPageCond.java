package top.rreeff.common.db;

public interface IPageCond{

	/**
	 * 获取查询时每页的大小
	 * 
	 * @return
	 */
	public  int getPageSize();

	/**
	 * 设置每页的大小
	 * 
	 * @param paramInt
	 */
	public  void setPageSize(int paramInt);

	/**
	 * 获取记录总数
	 * 
	 * @return
	 */
	public  int getCount();

	/**
	 * 设置记录总数
	 * 
	 * @param paramInt
	 */
	public  void setCount(int paramInt);

	/**
	 * 获取查询结果的总页数
	 * 
	 * @return
	 */
	public  int getTotalPage();

	/**
	 * 设置查询结果的总页数
	 * 
	 * @param paramInt
	 */
	public  void setTotalPage(int paramInt);
	
	/**
	 * 获取当前的页码
	 * 
	 * 
	 * @return
	 */
	public  int getCurrentPage();

	/**
	 * 设置当前的页码
	 * 
	 * @param paramInt
	 */
	public  void setCurrentPage(int paramInt);

	/**
	 * 获取是否要查询总数
	 * 
	 * 
	 * @return
	 */
	public  boolean getIsCount();

	/**
	 * 设置是否要查询总数
	 * 
	 * 
	 * @return
	 */
	public  void setIsCount(boolean paramBoolean);

	/**
	 * 获取是否是第一页
	 * 
	 * @return
	 */
	public  boolean getIsFirst();

	/**
	 * 获取是否是第一页
	 * 
	 * @return
	 */
	public  void setIsFirst(boolean paramBoolean);

	/**
	 * 获取是否是最后一页信息
	 * 
	 * @return
	 */
	public  boolean getIsLast();

	/**
	 * 设置是否是最后一页信息
	 * 
	 * @return
	 */
	public  void setIsLast(boolean paramBoolean);

	/**
	 * 获取当前页记录数
	 * 
	 * 
	 * @return
	 */
	public  int getSize();

	/**
	 * 设置当前页记录数
	 * 
	 * @param paramInt
	 */
	public  void setSize(int paramInt);
}

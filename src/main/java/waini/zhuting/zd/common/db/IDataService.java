package top.rreeff.common.db;

import java.util.List;
import java.util.Map;


/**
 * 数据库的操作接口,所有数据库的操作，都需要通过这些接口来实现数据库的操作。
 * 
 * 在该接口,针对数据库的操作需要考虑到未来集群环境、大并发量环境、读写分离情况下的实现。而针对开发人员，则仅关心所提供的接口而不需要
 * 
 * 关注接口的实现过程。<br>
 * 
 * 
 * 
 * 
 * 
 */
public interface IDataService<K,V,T> {
	
	
	/**
	 * 根据传入的类型信息，生成主键。在该方法中，需要支持在集群环境下，高并发的应用中<br>
	 * 
	 * 能够获取到唯一的主键信息。
	 * 
	 * @return
	 */
	public String getNextKey(String type);
	
	/**
	 * 根据传入的sql语句及参数，查询单条数据
	 * 
	 * @param statementSql
	 * @param params
	 * @return
	 */
	public T queryEntity(String statementSql,Object params) throws Exception;
	
	/**
	 * 根据传入的sqlId查询数据记录信息，不实现分页功能
	 * 
	 * @param statementSql
	 * @param params
	 * @return
	 */
	public List<T> queryList(String statementSql,Object params) throws Exception;
	
	/**
	 * 根据传入的sqlid及查询条件、分页信息等实现分页查询
	 * 
	 * @param statementSql
	 * @param params
	 * @param pageCond
	 * @return
	 */
	public List<T> queryList4Page(String statementSql,Object params,IPageCond pageCond) throws Exception;

	/**
	 * 根据传入的sqlId查询数据记录信息，结果以hash表的方式返回
	 * 
	 * @param statementSql
	 * @param params
	 * @return
	 */
	public Map<K,V> queryMap(String statementSql,Object params) throws Exception;
	
	/**
	 * 根据传入的sqlId查询数据记录信息，并实现分页的查询，结果以hash表的方式返回，
	 * 
	 * @param statementSql
	 * @param params
	 * @return
	 */
	public Map<K,V> queryMap4Page(String statementSql,Object params,IPageCond pageCond) throws Exception;
	
	/**
	 * 根据传入的sqlId以及参数信息，将数据插入到数据库中
	 * 
	 * @param statementSql
	 * @param params
	 */
	public int insert(String statementSql,Object params) throws Exception;
	
	/**
	 * 根据传入的sqlId以及参数信息，将数据批量插入到数据库中
	 * 
	 * @param statementSql
	 * @param params
	 */
	public int insertBatch(String statementSql,Object params) throws Exception;
	
	/**
	 * 根据传入的sqlId以及参数信息，将数据更新到数据库中
	 * 
	 * @param statementSql
	 * @param params
	 */
	public int update(String statementSql,Object params) throws Exception;
	
	/**
	 * 根据传入的sqlId以及参数信息，将数据批量更新到数据库中
	 * 
	 * @param statementSql
	 * @param params
	 */
	public int updateBatch(String statementSql,Object params) throws Exception;
	
	/**
	 * 根据传入的sqlId以及参数信息，删除数据库中的数据,返回的结果为删除的行数
	 * 
	 * @param statementSql
	 * @param params
	 */
	public int delete(String statementSql,Object params) throws Exception;
	
	/**
	 * 根据传入的sqlId以及参数信息，批量删除数据库中的数据,返回的结果为删除的行数
	 * 
	 * @param statementSql
	 * @param params
	 */
	public int deleteBatch(String statementSql,Object params) throws Exception;
	
	/**
	 * 根据传入的sqlId以及参数信息,计算符合条件的记录总数
	 * 
	 * @param statementSql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int count(String statementSql,Object params) throws Exception;

	
}

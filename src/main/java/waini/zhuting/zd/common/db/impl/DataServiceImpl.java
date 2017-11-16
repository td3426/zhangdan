package top.rreeff.common.db.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import top.rreeff.common.db.IDataService;
import top.rreeff.common.db.IPageCond;

public class DataServiceImpl<K, V, T> implements IDataService<K, V, T> {

	@Resource
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public String getNextKey(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T queryEntity(String statementSql, Object params) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		T t ;
		try {
			t = sqlSession.selectOne(statementSql, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 释放资源
			sqlSession.close();
		}
		return t;
	}

	@Override
	public int insert(String statementSql, Object params) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int i = 0;
		try {
			// 执行插入操作
			i =  sqlSession.insert(statementSql, params);
			// 提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 释放资源
			sqlSession.close();
		}
		return i;
	}

	@Override
	public int insertBatch(String statementSql, Object params)
			throws Exception {
		SqlSession batchSqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
		 int i = 0; 
		    try {
				i = batchSqlSession.insert(statementSql, params);
				batchSqlSession.commit();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}finally{
				batchSqlSession.close();
			}
		    return i;
	}

	@Override
	public int update(String statementSql, Object params) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int i=0;
		try {
			// 执行更新操作
			i = sqlSession.update(statementSql, params);
			// 提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 释放资源
			sqlSession.close();
		}
		return i;
	}

	@Override
	public int updateBatch(String statementSql, Object params)
			throws Exception {
		SqlSession batchSqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
		int i = 0;
		try {
			i = batchSqlSession.update(statementSql, params);
			batchSqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			batchSqlSession.close();
		}
		return i;

	}

	@Override
	public int delete(String statementSql, Object params) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行删除操作
		int i;
		try {
			i = sqlSession.delete(statementSql, params);
			// 提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 释放资源
			sqlSession.close();
		}
		return i;
	}

	@Override
	public int deleteBatch(String statementSql, Object params) throws Exception {
		SqlSession batchSqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
		int i;
		try {
			i = batchSqlSession.delete(statementSql, params);
			batchSqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			batchSqlSession.close();
		}
		return i;
	}

	@Override
	public int count(String statementSql, Object params) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行查询操作
		int i;
		try {
			i = sqlSession.selectOne(statementSql, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 释放资源
			sqlSession.close();
		}
		return i;
	}

	@Override
	public List<T> queryList(String statementSql, Object params)
			throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<T> list;
		try {
			list = sqlSession.selectList(statementSql, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 释放资源
			sqlSession.close();
		}
		return list;
	}

	@Override
	public List<T> queryList4Page(String statementSql, Object params,
			IPageCond pageCond) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<T> list;
		try {
			int CurrentPage = pageCond.getCurrentPage();
			int pageSize = pageCond.getPageSize();
			int offset = (CurrentPage - 1)*pageSize;
			RowBounds rowBounds = new RowBounds(offset,pageSize);
			list = sqlSession.selectList(statementSql, params, rowBounds);
			List<T> queryList = sqlSession.selectList(statementSql,params);
			pageCond.setCount(queryList.size());
			/*list.add(pageCond);*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 释放资源
			sqlSession.close();
		}
		return list;

	}

	@Override
	public Map<K, V> queryMap(String statementSql, Object params)
			throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<K, V> selectMap;
		try {
			Field[] fields = params.getClass().getDeclaredFields();
			String field = fields[0].toString();
			String id = field.substring(field.lastIndexOf(".")+1);
			selectMap = sqlSession.selectMap(statementSql, params, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 释放资源
			sqlSession.close();
		}
		return selectMap;
	}

	@Override
	public Map<K, V> queryMap4Page(String statementSql, Object params,
			IPageCond pageCond) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<K, V> selectMap ;
		try {
			Field[] fields = params.getClass().getDeclaredFields();
			String field = fields[0].toString();
			String id = field.substring(field.lastIndexOf(".")+1);
			int CurrentPage = pageCond.getCurrentPage();
			int pageSize = pageCond.getPageSize();
			int offset = (CurrentPage - 1)*pageSize;
			selectMap = sqlSession.selectMap(statementSql, params, id, new RowBounds(offset,pageSize));
			List<Object> queryList = sqlSession.selectList(statementSql,params);
			pageCond.setCount(queryList.size());
			/*selectMap.put((K)"pageCond", (V)pageCond);*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 释放资源
			sqlSession.close();
		}
		return selectMap;
	}

}

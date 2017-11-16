package top.rreeff.common.db.impl;

import top.rreeff.common.db.Dialect;
import top.rreeff.common.db.MySql5PageHepler;

/**
 * MySQL数据库方言
 * 
 * @author gziscas
 * @since 2014年5月18日 下午1:32:52
 **/
public class MySql5Dialect extends Dialect {

    protected static final String SQL_END_DELIMITER = ";";

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        return MySql5PageHepler.getLimitString(sql, offset, limit);
    }

    @Override
    public String getCountString(String sql) {
        return MySql5PageHepler.getCountString(sql);
    }
}

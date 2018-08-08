package org.study.newlife.v2.sqlsession;

import org.study.newlife.v2.config.Configuration;
import org.study.newlife.v2.config.MapperRegistry;
import org.study.newlife.v2.executor.Executor;

/**
 * @Auther: jim
 * @Date: 2018/8/5 17:32
 * @Description:
 */
public class SqlSession {
    private Configuration configuration;
    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }
    public <T> T getMapper(Class<T> clazz){
        return configuration.getMapper(clazz,this);
    }
    public <T> T selectOne(MapperRegistry.MapperData data,String param){
        return executor.query(data,param);
    }
}

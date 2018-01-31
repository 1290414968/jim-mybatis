package org.study.secondVersion;

import org.study.secondVersion.config.Configuration;
import org.study.secondVersion.config.MapperRegister;
import org.study.secondVersion.executor.Executor;
import org.study.secondVersion.mapper.MapperProxy;

import java.lang.reflect.Proxy;

/**
 * @author jim
 * @create 2018-01-30 18:42
 **/
public class SqlSession {
    private Executor executor;
    private Configuration configuration;
    public SqlSession(Executor executor, Configuration configuration) {
        this.executor = executor;
        this.configuration = configuration;
    }
    public <T> T selectOne(MapperRegister.MapperData data,Object param) {
        return executor.query(data,param);
    }
    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz}, new MapperProxy(this));
    }
    public Configuration getConfiguration() {
        return configuration;
    }
}

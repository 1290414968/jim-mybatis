package org.study.firstVersion;

import java.lang.reflect.Proxy;

/**
 * @author jim
 * @create 2018-01-30 18:42
 **/
public class SqlSession {
    private Executor executor = new SimpleExecutor();
    public <T> T selectOne(String statement,String parameter) {
        return executor.query(statement,parameter);
    }
    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz}, new MapperProxy(this));
    }
}

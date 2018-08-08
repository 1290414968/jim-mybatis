package org.study.newlife.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: jim
 * @Date: 2018/8/4 15:59
 * @Description:
 */
public class MapperProxy implements InvocationHandler {
    private SqlSession sqlSession;
    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(Configuration.MapperXml.namespace)){//动态代理模式下的设计模式的必须的判断逻辑
            return sqlSession.selectOne(Configuration.MapperXml.nameSqlMap.get(method.getName()),String.valueOf(args[0]));
        }
        return null;
    }
}

package org.study.newlife.v2.mapper;

import org.study.newlife.v2.config.MapperRegistry;
import org.study.newlife.v2.sqlsession.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: jim
 * @Date: 2018/8/5 17:42
 * @Description:
 */
public class MapperProxy implements InvocationHandler {
    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperRegistry.MapperData data = MapperRegistry.mapperMap.get(method.getDeclaringClass().getName()+"."+method.getName());
        if(data!=null){
            return sqlSession.selectOne(data,String.valueOf(args[0]));
        }
        return null;
    }
}

package org.study.secondVersion.mapper;

import org.study.secondVersion.SqlSession;
import org.study.secondVersion.config.MapperRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jim
 * @create 2018-01-31 15:53
 **/
public class MapperProxy implements InvocationHandler {
    private SqlSession sqlSession;
    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperRegister register =  sqlSession.getConfiguration().getMapperRegister();
        String defineMethodName = method.getDeclaringClass().getName()+"."+method.getName();
        MapperRegister.MapperData data =  register.getByName(defineMethodName);
        if(data!=null){
            System.out.println(String.format("SQL [ %s ], parameter [%s] ", data.getSql(), args[0]));
            return sqlSession.selectOne(data,String.valueOf(args[0]));
        }
        return null;
    }
}

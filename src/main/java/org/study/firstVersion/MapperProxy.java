package org.study.firstVersion;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jim
 * @create 2018-01-30 18:50
 **/
public class MapperProxy<T> implements InvocationHandler {
    private final SqlSession sqlSession;
    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       if(method.getDeclaringClass().getName().equals(MapperSql.NAME_SPACE_USER_SELECT_BYPRIMARY_KEY)){
            String sql = MapperSql.NAME_SPACE_MAP.get(method.getName());
            return sqlSession.selectOne(sql,String.valueOf(args[0]));
       }
       return null;
    }
}

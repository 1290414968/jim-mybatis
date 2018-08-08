package org.study.newlife.v2.config;
import org.study.newlife.v2.mapper.MapperProxy;
import org.study.newlife.v2.sqlsession.SqlSession;
import java.lang.reflect.Proxy;
/**
 * @Auther: jim
 * @Date: 2018/8/5 14:09
 * @Description:
 */
public class Configuration  {
    public <T> T getMapper(Class<T> clazz,SqlSession sqlSession) {
        return  (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));
    }
}

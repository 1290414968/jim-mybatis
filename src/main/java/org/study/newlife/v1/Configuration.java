package org.study.newlife.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
    public <T> T getMapper(Class clazz,SqlSession sqlSession) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));
    }
    static class MapperXml {
        public static String namespace = "org.study.newlifeFirst.UserMapper";
        public static Map<String,String> nameSqlMap = new HashMap<String,String>();
        static{
            nameSqlMap.put("selectByPrimaryKey","select * from user_info where id = %d");
        }
    }
}

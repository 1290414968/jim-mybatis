package org.study.newlife.v2.config;

import org.study.beans.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: jim
 * @Date: 2018/8/5 14:11
 * @Description:
 */
public class MapperRegistry {
    public static  final Map<String,MapperRegistry.MapperData> mapperMap = new HashMap<String, MapperRegistry.MapperData>();
    static  {
        mapperMap.put("org.study.newlife.v2.mapper.UserMapper.selectByPrimaryKey",
                new MapperRegistry.MapperData("select * from user_info where id = %d",User.class));
    }
    public static class MapperData<T>{
        private String sql;
        private Class<T> clazz;

        public MapperData(String sql, Class<T> clazz) {
            this.sql = sql;
            this.clazz = clazz;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Class<T> getClazz() {
            return clazz;
        }

        public void setClazz(Class<T> clazz) {
            this.clazz = clazz;
        }
    }
}

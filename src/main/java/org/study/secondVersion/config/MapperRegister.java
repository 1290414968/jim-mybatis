package org.study.secondVersion.config;

import org.study.beans.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jim
 * @create 2018-01-31 15:55
 **/
public class MapperRegister {
    private static  final Map<String,MapperData> mapperMap = new HashMap<String, MapperData>();
    public MapperRegister() {
        mapperMap.put("org.study.secondVersion.mapper.UserMapper.selectByPrimaryKey",new MapperData("select * from user_info where id = %d",User.class));
    }
    public class MapperData<T>{
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
    public MapperData getByName(String nameSpace){
        return  mapperMap.get(nameSpace);
    }
}

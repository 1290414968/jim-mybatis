package org.study.newlife.v2.resultset;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @Auther: jim
 * @Date: 2018/8/5 18:02
 * @Description:
 */
public class ResultSetHandler {
    public <T> T handler(ResultSet resultSet, Class clazz) {
        Object resultObj = new DefaultObjectFactory().create(clazz);
        try {
            if(resultSet.next()){
                Field[] fields = resultObj.getClass().getDeclaredFields();
                for(Field field:fields){
                    String setMethodName =  "set"+upperCapital(field.getName());
                    Method method =  resultObj.getClass().getMethod(setMethodName,field.getType());
                    method.invoke(resultObj,getResult(field,resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)resultObj;
    }
    private Object getResult(Field field, ResultSet rs) throws SQLException {
        // simple type handler
        Class<?> type = field.getType();
        if(Long.class == type){
            return rs.getLong(field.getName());
        }
        if(String.class == type){
            return rs.getString(field.getName());
        }
        return rs.getString(field.getName());
    }
    private String upperCapital(String name) {
        String first = name.substring(0, 1);
        String tail = name.substring(1);
        return first.toUpperCase() + tail;
    }
}

package org.study.newlife.v1;
/**
 * @Auther: jim
 * @Date: 2018/8/2 20:01
 * @Description:
 */
public class SqlSession {
    private Configuration configuration;
    private Executor executor;
    //1、面向对象的思维：定义类的关系
    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * 2、定义类的行为9997777777777777777777777777777777777777777777777777777777777777
     */
    public <T> T getMapper(Class clazz){
       return  configuration.getMapper(clazz,this);
    }
    public <T> T selectOne(String statement,String param){
        return executor.query(statement,param);
    }
}

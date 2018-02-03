package org.study.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.study.beans.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class UseMapperTest {
    public  static SqlSession getSqlSession() throws FileNotFoundException {
        InputStream configFile  = new FileInputStream("F:\\gpworkspace\\jim-mybatis" +
                    "\\src\\main\\resources\\mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        return sqlSessionFactory.openSession(false);
    }
    public static User get(SqlSession sqlSession, Long id) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.selectByPrimaryKey(id);
    }
    public static int insert(SqlSession sqlSession,User user){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.insert(user);
    }
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            User user = new User();
//            user.setName("张无忌");
//            user.setType("武林大侠");
//            insert(sqlSession,user);
//            user.setName("张三丰");
//            user.setType("武林传说");
//            insert(sqlSession,user);
            long startTime = System.currentTimeMillis();
            user = get(sqlSession,7L);
            System.out.println(user.toString());
            System.out.println(System.currentTimeMillis()-startTime);
            startTime = System.currentTimeMillis();
            user = get(sqlSession,7L);
            System.out.println(user.toString());
            System.out.println(System.currentTimeMillis()-startTime);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }
}

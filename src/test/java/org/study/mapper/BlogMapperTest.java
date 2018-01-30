package org.study.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.study.beans.Blog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BlogMapperTest {
    public  static SqlSession getSqlSession() throws FileNotFoundException {
        InputStream configFile  = new FileInputStream("F:\\gpworkspace\\jim-mybatis" +
                    "\\src\\main\\resources\\mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        return sqlSessionFactory.openSession(false);
    }
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = null;
            blog = blogMapper.selectAssociationById(1l);
            blog = blogMapper.selectAssociationByResultById(1L);
            blog = blogMapper.selectResultTypeById(1L);
            System.out.println(blog);
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

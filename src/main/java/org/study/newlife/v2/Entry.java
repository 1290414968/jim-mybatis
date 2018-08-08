package org.study.newlife.v2;

import org.study.beans.User;
import org.study.newlife.v2.config.Configuration;
import org.study.newlife.v2.executor.DefaultExecutor;
import org.study.newlife.v2.mapper.UserMapper;
import org.study.newlife.v2.sqlsession.SqlSession;

/**
 * @Auther: jim
 * @Date: 2018/8/4 16:14
 * @Description:
 */
public class Entry {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new Configuration(),new DefaultExecutor());
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user =  userMapper.selectByPrimaryKey(7L);
        System.out.println(user);
    }
}

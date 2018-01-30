package org.study.firstVersion;

import org.study.beans.User;

/**
 * @author jim
 * @create 2018-01-30 18:56
 **/
public class Bootstrap {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user  = userMapper.selectByPrimaryKey(7L);
        System.out.printf(user.toString());
    }
}

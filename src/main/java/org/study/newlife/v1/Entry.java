package org.study.newlife.v1;

import org.study.beans.User;

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

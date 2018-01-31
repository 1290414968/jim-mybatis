package org.study.secondVersion;

import org.study.beans.User;
import org.study.secondVersion.config.Configuration;
import org.study.secondVersion.executor.ExecutorFactory;
import org.study.secondVersion.executor.ExecutorType;
import org.study.secondVersion.mapper.UserMapper;

/**
 * @author jim
 * @create 2018-01-30 18:56
 **/
public class Bootstrap {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        SqlSession sqlSession = new SqlSession(ExecutorFactory.get(ExecutorType.SIMPLE),configuration);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(7l);
        System.out.println(user.toString());
    }
}

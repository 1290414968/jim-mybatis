package org.study.mapper;

import org.apache.ibatis.annotations.Param;
import org.study.beans.User;
import org.study.beans.UserExample;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * 用来测试org.apache.ibatis.binding.MapperProxy.invoke的isDefaultMethod的进入条件，接口默认方法，java 8之后的新特性的实现
     */
    default public void test() {};
}
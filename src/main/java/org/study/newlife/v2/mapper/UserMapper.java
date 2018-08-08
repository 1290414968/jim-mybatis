package org.study.newlife.v2.mapper;

import org.study.beans.User;

/**
 * @Auther: jim
 * @Date: 2018/8/5 17:42
 * @Description:
 */
public interface UserMapper {
    User selectByPrimaryKey(Long id);
}

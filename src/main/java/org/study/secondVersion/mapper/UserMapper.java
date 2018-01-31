package org.study.secondVersion.mapper;

import org.study.beans.User;

/**
 * @author jim
 * @create 2018-01-31 16:14
 **/
public interface UserMapper {
    User selectByPrimaryKey(Long userId);
}

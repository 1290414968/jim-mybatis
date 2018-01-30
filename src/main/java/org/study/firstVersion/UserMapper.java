package org.study.firstVersion;

import org.study.beans.User;

/**
 * @author jim
 * @create 2018-01-30 18:54
 **/
public interface UserMapper {
    User selectByPrimaryKey(Long userId);
}

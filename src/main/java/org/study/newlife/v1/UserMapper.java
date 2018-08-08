package org.study.newlife.v1;
import org.study.beans.User;
/**
 * @Auther: jim
 * @Date: 2018/8/4 16:02
 * @Description:
 */
public interface UserMapper {
    User selectByPrimaryKey(Long id);
}

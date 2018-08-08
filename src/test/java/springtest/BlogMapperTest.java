package springtest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.dal.User;
import org.study.dal.UserMapper;


public class BlogMapperTest extends BaseTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testGet(){
        User user = userMapper.selectByPrimaryKey(7L);
        System.out.println(user);
    }
}

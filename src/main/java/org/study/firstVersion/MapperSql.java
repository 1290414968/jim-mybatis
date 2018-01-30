package org.study.firstVersion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jim
 * @create 2018-01-30 19:09
 **/
public class MapperSql {
    public final static String NAME_SPACE_USER_SELECT_BYPRIMARY_KEY = "org.study.firstVersion.UserMapper";
    public final static Map<String,String> NAME_SPACE_MAP = new HashMap<String,String>();
    static {
        NAME_SPACE_MAP.put("selectByPrimaryKey","select * from user_info where id = %d");
    }
}

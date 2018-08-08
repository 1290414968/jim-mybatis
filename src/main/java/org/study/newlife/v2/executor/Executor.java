package org.study.newlife.v2.executor;

import org.study.newlife.v2.config.MapperRegistry;

/**
 * @Auther: jim
 * @Date: 2018/8/5 17:55
 * @Description:
 */
public interface Executor {
    <T> T query(MapperRegistry.MapperData data, String param);
}

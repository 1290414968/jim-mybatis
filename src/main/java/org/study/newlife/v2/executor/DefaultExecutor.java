package org.study.newlife.v2.executor;

import org.study.newlife.v2.config.MapperRegistry;
import org.study.newlife.v2.statement.StatementHandler;

/**
 * @Auther: jim
 * @Date: 2018/8/5 14:10
 * @Description:
 */
public class DefaultExecutor implements Executor {
    @Override
    public <T> T query(MapperRegistry.MapperData data, String param) {
        return (T)new StatementHandler().handler(data,param);
    }
}

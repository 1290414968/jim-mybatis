package org.study.secondVersion.executor;

import org.study.secondVersion.config.MapperRegister;
import org.study.secondVersion.statement.StatementHandler;

/**
 * @author jim
 * @create 2018-01-31 16:32
 **/
public class SimpleExecutor implements  Executor {
    public <T> T query(MapperRegister.MapperData data, Object param) {
        return (T)new StatementHandler().handler(data,param);
    }
}

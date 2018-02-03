package org.study.secondVersion.executor;

import org.study.secondVersion.config.MapperRegister;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jim
 * @create 2018-01-31 16:32
 **/
public class CacheExecutor implements  Executor {
    private SimpleExecutor delegate;
    private Map<String,Object> localCache = new HashMap();
    public <T> T query(MapperRegister.MapperData data, Object param) {
        Object object = localCache.get(data.getSql());
        if(object!=null){
            System.out.println("get cache");
            return (T)object;
        }
        delegate = new SimpleExecutor();
        localCache.put(data.getSql(),delegate);
        return delegate.query(data,param);
    }
}

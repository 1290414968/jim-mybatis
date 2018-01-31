package org.study.secondVersion.executor;

/**
 * @author jim
 * @create 2018-01-31 16:40
 **/
public class ExecutorFactory {
    public static Executor get(ExecutorType type){
        if(ExecutorType.SIMPLE.equals(type)){
            return new SimpleExecutor();
        }else if(ExecutorType.CACHE.equals(type)){
            return new CacheExecutor();
        }
        throw new RuntimeException("no executor get");
    }
}

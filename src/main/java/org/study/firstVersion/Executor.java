package org.study.firstVersion;

public interface Executor {
    public <E> E query(String statement, Object parameter);
}

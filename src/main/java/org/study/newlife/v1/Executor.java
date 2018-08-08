package org.study.newlife.v1;
public interface Executor {
    <T> T query(String statement, String param);
}

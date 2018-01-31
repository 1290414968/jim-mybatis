package org.study.secondVersion.executor;

import org.study.secondVersion.config.MapperRegister;

public interface Executor {
  <T> T query(MapperRegister.MapperData data, Object param);
}

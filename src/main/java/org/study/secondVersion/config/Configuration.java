package org.study.secondVersion.config;

/**
 * @author jim
 * @create 2018-01-31 15:46
 **/
public class Configuration {
    private final MapperRegister mapperRegister = new MapperRegister();
    private  String scanPath;
    public Configuration scanPath(String scanPath){
        this.scanPath = scanPath;
        return this;
    }
    public MapperRegister getMapperRegister() {
        return mapperRegister;
    }
}

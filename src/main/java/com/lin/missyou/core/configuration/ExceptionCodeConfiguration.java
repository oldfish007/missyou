package com.lin.missyou.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 *  配置文件就看成是一个类
 *  如果需要springboot和类进行一个对应的话
 *  指定配置文件源文件 类和配置文件关联起来了
 * @Component ExceptionCodeConfiguration 必须要将类注入到容器里面去
 */
@ConfigurationProperties(prefix = "free")
@PropertySource(value="classpath:config/exception-code.properties")
@Component
public class ExceptionCodeConfiguration {

    private Map<Integer,String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }

    public String getMessage(int code){
        String s = codes.get(code);
        return s;
    }
}

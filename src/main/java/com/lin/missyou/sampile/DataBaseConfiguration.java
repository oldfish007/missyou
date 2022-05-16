package com.lin.missyou.sampile;

import com.lin.missyou.sampile.database.MySQL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-02-22 13:25
 */
@Configuration
public class DataBaseConfiguration {
   //@Value("${mysql.ip}")
    private String ip;
   // @Value("${mysql.port}")
    private Integer port;
     //表示容器里面没有mysql这个容器
    @Bean
    public IConnect mysql(){
        return new MySQL(this.ip,this.port);
    }
}

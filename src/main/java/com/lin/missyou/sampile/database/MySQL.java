package com.lin.missyou.sampile.database;

import com.lin.missyou.sampile.IConnect;
import org.springframework.stereotype.Component;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-02-22 13:21
 */

public class MySQL implements IConnect{

    private String ip="localhost";
    private Integer port=3306;

    public MySQL(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    public MySQL() {
    }

    @Override
    public void connect() {
        System.out.println(this.ip+":"+this.port);
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}

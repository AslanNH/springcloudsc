package com.nh.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author nihh
 * @Date 2021/5/6 11:40
 * @Version 1.0
 **/
@ConfigurationProperties(prefix="nacos", ignoreUnknownFields = true)
@Configuration
public class NacosGatewayProperties {

    private String address;

    private String dataId;

    private String group;

    private Long timeout;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getGroupId() {
        return group;
    }

    public void setGroupId(String group) {
        this.group = group;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }
}
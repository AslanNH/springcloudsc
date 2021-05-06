package com.nh.gateway.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Description
 * @Author nihh
 * @Date 2021/5/6 11:41
 * @Version 1.0
 **/
@Component
@NacosPropertySource(dataId = "${nacos.data-id}", autoRefreshed = true, groupId = "${nacos.group}")
public class DynamicRouteServiceImplByNacos implements CommandLineRunner {

    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;

    @Autowired
    private NacosGatewayProperties nacosGatewayProperties;

    /**
     * 监听Nacos Server下发的动态路由配置
     */
    public void dynamicRouteByNacosListener (){
        try {
            ConfigService configService= NacosFactory.createConfigService(nacosGatewayProperties.getAddress());
            String content = configService.getConfig(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroupId(), nacosGatewayProperties.getTimeout());
            // 1.刚开始需要加载配置，而不是等到触发监听才去加载
            if(StringUtils.isNotEmpty(content)) {
                updateDefinition(content);
            }
            // 2.nacos修改配置时，会触发监听器
            configService.addListener(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroupId(), new Listener()  {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    updateDefinition(configInfo);
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        dynamicRouteByNacosListener();

    }

    /**
     * 更新路由配置
     * @param content
     */
    private void updateDefinition(String content){
        List<RouteDefinition> list = JSONObject.parseArray(content, RouteDefinition.class);
        list.forEach(definition->{
            dynamicRouteService.update(definition);
        });
    }

}
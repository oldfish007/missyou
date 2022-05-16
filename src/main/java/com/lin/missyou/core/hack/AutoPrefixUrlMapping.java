package com.lin.missyou.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 定义一个普普通通的类是不能够被spring发现的
 * 由容器中的 AutoPrefixConfiguration进行实例化
 *
 */
public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {
    @Value("${missyou.api-package}")
    private String  apiPackagePath;
    /**
     * 定义和生成请求的路由信息
     * @param method
     * @param handlerType
     * @return
     */
    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        //com.lin.missyou.api.vi
        if(mappingInfo!=null){
            String prefix = this.getPrefix(handlerType);
            return RequestMappingInfo.paths(prefix).build().combine(mappingInfo);
        }
        return mappingInfo;
    }

    private String getPrefix(Class<?> handlerType){

        String packageName = handlerType.getPackage().getName();
        String dotPath = packageName.replaceAll(this.apiPackagePath,"");
        return dotPath.replace(".","/");
    }
}

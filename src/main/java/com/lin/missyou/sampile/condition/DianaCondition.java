package com.lin.missyou.sampile.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.Annotation;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-02-22 16:58
 */
public class DianaCondition implements Condition {
    /**
     *
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return 返回true就表示他加入到容器里面去
     *   返回false就不会加入到容器里面去
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
       String name = conditionContext.getEnvironment().getProperty("hero.condition");
        return "diana".equalsIgnoreCase(name);
        //return false;
    }
}

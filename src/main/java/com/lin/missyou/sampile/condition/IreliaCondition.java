package com.lin.missyou.sampile.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-02-22 17:04
 */
public class IreliaCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String name = conditionContext.getEnvironment().getProperty("hero.condition");
        return "irelia".equalsIgnoreCase(name);
    }
}

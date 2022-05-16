package com.lin.missyou.sampile;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-02-23 16:21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(LOLConfigurationSelector.class) //模块装配
public @interface EnableLOLConfiguration {
}

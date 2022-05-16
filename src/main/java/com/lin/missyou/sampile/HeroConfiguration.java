package com.lin.missyou.sampile;

import com.lin.missyou.sampile.condition.DianaCondition;
import com.lin.missyou.sampile.condition.IreliaCondition;
import com.lin.missyou.sampile.hero.Camille;
import com.lin.missyou.sampile.hero.Diana;
import com.lin.missyou.sampile.hero.Irelia;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-02-22 12:23
 * 是否加入到容器里面都是通过配置类来决定的
 * 通过条件注解的方式选择只加入哪一个
 */
@Configuration
public class HeroConfiguration {
    /**
     * 如果配置文件里面配置的是diana，diana就会加入到容器里面去
     * @return
     */
   // @Bean
   // @Conditional(DianaCondition.class)
    //配置文件中的配置条件  havingValue=“dinan” 满足了diana的条件 diana的bean就会加入到条件里面去
    //@ConditionalOnProperty(value = "hero.condition",havingValue = "diana",matchIfMissing=true)
    @ConditionalOnBean(name="mysql")
    public ISkill Diana(){
        return new Diana("diana",22);
    }

    /**
     * 如果配置文件配置的是irelia,irelia就会加入到容器里面去
     * @return
     */
    @Bean
    //@Conditional(IreliaCondition.class)
        @ConditionalOnProperty(value = "hero.condition",havingValue = "irelia")
    //@ConditionalOnMissingBean(name="mysql")
    public ISkill irelia(){
        return new Irelia("irelia",22);
    }

}
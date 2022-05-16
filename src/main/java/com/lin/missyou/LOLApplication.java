package com.lin.missyou;

import com.lin.missyou.sampile.EnableLOLConfiguration;
import com.lin.missyou.sampile.HeroConfiguration;
import com.lin.missyou.sampile.ISkill;
import com.lin.missyou.sampile.LOLConfigurationSelector;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**ComponentScan回去扫描web服务器相关的配置
 *@Import 主动的直接的把某一个配置导入到ioc容器里面去
 * 第二个用法是在
 */
//@ComponentScan
//@Import(LOLConfigurationSelector.class)
@EnableLOLConfiguration
public class LOLApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(LOLApplication.class)
                        .web(WebApplicationType.NONE)
                .run(args);
        ISkill iSkill = (ISkill)context.getBean("irelia");
        iSkill.r();
    }
}

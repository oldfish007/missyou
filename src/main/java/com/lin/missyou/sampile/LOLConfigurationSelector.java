package com.lin.missyou.sampile;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**自动配置机制
 * 这地方可以导入多个配置类 HeroConfiguration DataBaseConfiguration
 * @author oldfish
 * @version 1.0
 * @date 2020-02-23 16:13
 */
public class LOLConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HeroConfiguration.class.getName()};
    }
}

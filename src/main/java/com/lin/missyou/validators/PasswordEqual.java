package com.lin.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME) //注解保留到运行的阶段
@Target({ElementType.TYPE})
@Constraint(validatedBy = PasswordValidator.class) //把一个注解和一个相关的类关联在一起的呢
public @interface PasswordEqual {
    int min()  default 4;
    int max() default 8;
    String message() default "password are not equal";
    Class<?>[] groups() default {};
    Class <? extends Payload>[] payload() default {};
    //关联类

}

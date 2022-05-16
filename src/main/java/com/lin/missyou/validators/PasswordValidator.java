package com.lin.missyou.validators;

import com.lin.missyou.dto.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/***
 * 第二个类型是他所修饰的目标类型
 */
public class PasswordValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {
    //第二个：自定义注解修饰的目标类型
    private int max;
    private int min;

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(PersonDTO personDTO, ConstraintValidatorContext constraintValidatorContext) {

        String password1 = personDTO.getPassword1();
        String password2 = personDTO.getPassword2();
        boolean match = password1.equals(password2);
        return match;
    }

}

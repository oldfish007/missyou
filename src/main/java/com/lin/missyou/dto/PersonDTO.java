package com.lin.missyou.dto;



import com.lin.missyou.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/*@Getter
@Setter
//@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Builder
@Getter
@PasswordEqual(min = 2,message = "两次输入密码不一致")
public class PersonDTO {
    @Length(min = 2,max = 7,message = "姓名长度没有落在区间里面")
    private String name;
    private String age;

    private String password1;
    private String password2;
}

package com.lin.missyou.sampile.hero;

import com.lin.missyou.sampile.ISkill;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-02-20 17:30
 */
/*@Component
@Primary*/
public class Diana implements ISkill{
    private String name;
    private int age;

    public Diana(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Diana() {
        System.out.println("this is Diana");
    }

    public void g(){
        System.out.println("Diana G");
    }
    public void w(){
        System.out.println("Diana w");
    }
    public void e(){
        System.out.println("Diana e");
    }
    public void r(){
        System.out.println("Diana r");
    }


}

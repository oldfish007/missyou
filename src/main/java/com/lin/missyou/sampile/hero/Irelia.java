package com.lin.missyou.sampile.hero;

import com.lin.missyou.sampile.ISkill;
import org.springframework.stereotype.Component;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-02-20 23:43
 */
//@Component
public class Irelia implements ISkill {
    private String name;
    private int age;

    public Irelia(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Irelia(){
        System.out.println("Irelia constructor");
    }
    @Override
    public void g() {
        System.out.println("Irelia g");
    }

    @Override
    public void w() {
        System.out.println("Irelia w");
    }

    @Override
    public void e() {
        System.out.println("Irelia e");
    }

    @Override
    public void r() {
        System.out.println("Irelia:"+this.name+this.age);
        System.out.println("Irelia r");
    }
}

package com.lin.missyou.sampile.hero;

import com.lin.missyou.sampile.ISkill;
import org.springframework.stereotype.Component;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-02-22 12:22
 */
//@Component
public class Camille implements ISkill{
    private String name;
    private int age;

    public Camille(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Camille(){
        System.out.println("Camille constructor");
    }
    @Override
    public void g() {
        System.out.println("Camille g");
    }

    @Override
    public void w() {
        System.out.println("Camille w");
    }

    @Override
    public void e() {
        System.out.println("Camille e");
    }

    @Override
    public void r() {
        System.out.println("Camille r");
    }
}


package com.lin.missyou.model1;


import javax.persistence.*;
import java.util.List;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-03-03 16:50
 */
//去孤子

public class Spu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subTitle;
    @ManyToMany(mappedBy = "spuList")
    private List<Theme> themeList;
}

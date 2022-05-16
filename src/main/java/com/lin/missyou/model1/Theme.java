package com.lin.missyou.model1;

import javax.persistence.*;
import java.util.List;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-03-03 16:49
 */

public class Theme {
    @Id
    private Long id;
    private String name;
    private String title;
    @ManyToMany
    @JoinTable(name="theme_spu",joinColumns = @JoinColumn(name="theme_id"),
                inverseJoinColumns = @JoinColumn(name="spu_id"))
    private List<Spu> spuList;
}

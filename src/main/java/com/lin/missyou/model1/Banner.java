package com.lin.missyou.model1;

import com.lin.missyou.model.BannerItem;

import javax.persistence.*;
import javax.validation.Constraint;
import java.util.List;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-03-02 17:07
 */

public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 16)
    private String name;
    @Transient
    private String description;
    private String img;
    private String title;
    @OneToMany(mappedBy = "banner")
    private List<BannerItem> items;
}

package com.lin.missyou.model1;

import com.lin.missyou.model.Banner;
import com.lin.missyou.model.BaseEntity;

import javax.persistence.*;

/**
 * @author oldfish
 * @version 1.0
 * @date 2020-03-03 10:44
 * banner的实体·
 * 一个Banner对应多个bannerItem
 */

public class BannerItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String img;
    private String keyword;
    private Short type;
    private String name;
   // private long bannerId;
    @ManyToOne
    @JoinColumn(insertable = false,updatable = false,name="bannerId")
    private Banner banner;

}

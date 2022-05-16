package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null and online=1")
public class Spu extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subtitle;
    private Long categoryId;
    private Long rootCategoryId;
    private boolean online;
    private String price;
    private Long sketchSpecId;
    private Long defaultSkuId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private boolean isTest;
    //private Object spuThemeImg;
    private String forThemeImg;

    /**
     * 单向一对多配置，并且设置上名字
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="spuId")
    private List<Sku> skuList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="spuId")
    private List<SpuImg> spuImgList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="spuId")
    private List<SpuDetailImg> spuDetailImgList;

}

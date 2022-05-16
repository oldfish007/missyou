package com.lin.missyou.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 前端需要什么属性，就给他返回什么属性
 */
@Getter
@Setter
public class SpuSimplifyVO {

    private Long id;
    private String title;
    private String subtitle;
    private String img;
    private String forThemeImg;
    private String price;
    private String discountPrice;
    private String description;
    private String tags;
    private Long sketchSpecId;

}

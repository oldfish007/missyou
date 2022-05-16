package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "banner_item", schema = "missyou", catalog = "")
@Getter
@Setter
public class BannerItem extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img;
    private String keyword;
    private short type;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private String name;
    private Long bannerId;
    //多方是关系的控制方也是维护端
   /* @ManyToOne
    @JoinColumn(insertable = false,updatable = false,name="bannerId")
    private Banner banner;*/


}

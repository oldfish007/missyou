package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null ")
public class Banner extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    private String title;
    private String img;

    @OneToMany(fetch = FetchType.LAZY) //开启懒加载模式
    @JoinColumn(name="bannerId")
    private List<BannerItem> bannerItemList;

}

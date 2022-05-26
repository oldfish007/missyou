package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null and online=1")
public class Theme extends BaseEntity {
    @Id
    private int id;
    private String title;
    private String description;
    private String name;
    private String tplName;
    private String entranceImg;
    private String extend;
    private String internalTopImg;
    private String titleImg;
    private Byte online;
    /**
     * @JoinTable第三张关系表配置 规范第三张表外键的名称joinColumns当前模型在第三张表里面的关联外键
     * inverseJoinColumns 指定另外一个外键的名称
     * 通过jpa orm生成的第三张表因为没有外键id,那么我们可否写一个第三张表的模型，如果第三张表没有实际的业务意义，那么不推荐再去增加工作量写一个模型
     */
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name="Theme_spu",joinColumns = @JoinColumn(name="theme_id"),inverseJoinColumns = @JoinColumn(name="spu_id"))
    private List<Spu> spuList;

}

package com.lin.missyou.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lin.missyou.util.GenericAndJson;
import com.lin.missyou.util.ListAndJson;
import com.lin.missyou.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 目前没有SKU导航SPU的需求，目前没有进行到那一步就先不写表和关系
 */
@Entity
@Getter
@Setter
public class Sku extends BaseEntity {
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;
    /**
     * 有时候不想去做级联的查询，是可以选择做一个冗余字段的
      */
    private Long categoryId;
    private Long rootCategoryId;
   // private List<Spec> specs; //Basic' attribute type should not be a container  这是当成数据库字段的映射肯定不行的
    //单体的json和map之间的映射  单体的映射成map  那么数组呢[{},{}]
//    @Convert(converter = MapAndJson.class)
//    private Map<String,Object> test;
//    @Convert(converter = ListAndJson.class)
    private String specs;

    public List<Spec> getSpecs() {
        if(this.specs==null){
            return null;
        }
        return GenericAndJson.jsonToObject(this.specs, new TypeReference<List<Spec>>() {
        });//传入了一个json字符串
    }

    public void setSpecs(List<Spec> specs) {
        if(specs.isEmpty()){
            return ;
        }
        this.specs = GenericAndJson.objectToJson(specs);
    }

    private String code; //每个SKU必须要有个唯一的标识
    private Long stock;

}

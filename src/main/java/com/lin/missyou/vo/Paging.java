package com.lin.missyou.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Paging<T> {

    private Long total;
    private Integer count;
    private Integer page;
    private Integer totalPage;
    private List<T> items;

    public Paging(Page<T> pageT){
        this.initPageParameters(pageT);
        this.items = pageT.getContent();
    }

    void initPageParameters(Page<T> pageT){
        this.total = pageT.getTotalElements();//总条数
        this.count = pageT.getSize();//每页显示数据
        this.page = pageT.getNumber();
        this.totalPage = pageT.getTotalPages(); //总页数
    }
}

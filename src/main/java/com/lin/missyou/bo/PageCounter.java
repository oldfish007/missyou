package com.lin.missyou.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageCounter {

    private Integer page;// 页码
    private Integer count;//每页显示数
}

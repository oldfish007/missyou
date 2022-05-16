package com.lin.missyou.util;


import com.lin.missyou.bo.PageCounter;

/**
 * business object ===== bo
 * service向controller返回数据要定义一个新的类
 * DAO 是数据层向业务层返数据
 */
public class CommonUtil {

    public static PageCounter convertToPageParameter(Integer start,Integer count){
        int pageNum = start/count;
        PageCounter pageCounter = PageCounter.builder()
                                    .page(pageNum)
                                    .count(count)
                                    .build();
        return pageCounter;
    }
}

package com.lin.missyou.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * paging服务于各种各样的entity
 * 做属性复制
 * 最终返回形势应该和pa
 * 原数据类型是T就是spu,目标其实也是不确定的
 * 下面这段代码在spuController
 */
public class PagingDozer<T,K> extends Paging{

    /**
     *
     * @param pageT
     * @param classK
     */
    public PagingDozer(Page<T> pageT,Class<K> classK){

        this.initPageParameters(pageT);
        List<T> tList = pageT.getContent();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> voList = new ArrayList<>();
        tList.forEach(t->{
            // t 源类 复制到 classK 目标类
            K vo = mapper.map(t,classK);
            voList.add(vo);
        });
        this.setItems(voList);
    }
}

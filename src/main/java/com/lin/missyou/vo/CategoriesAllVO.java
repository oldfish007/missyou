package com.lin.missyou.vo;

import com.lin.missyou.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据过多冗余了，需要过滤掉一些数据
 * 在model里面有一个导航关系就会多出很多数据出来
 *
 */
@Getter
@Setter
public class CategoriesAllVO {

    public List<CategoryPureVO> roots;
    private List<CategoryPureVO> subs;

    public CategoriesAllVO(Map<Integer,List<Category>> map){
       /* List<Category> roots = map.get(1);
        roots.forEach(category -> {
            CategoryPureVO categoryPureVO = new CategoryPureVO(category);
             this.roots.add(categoryPureVO);
        });*/
        List<Category> roots = map.get(1);

        this.roots = map.get(1).stream()
                    .map(r->{
                        return new CategoryPureVO(r);
                    })
                .collect(Collectors.toList());
        this.subs = map.get(2)
                .stream().map(CategoryPureVO::new)
                .collect(Collectors.toList());


    }
}

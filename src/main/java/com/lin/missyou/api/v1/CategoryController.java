package com.lin.missyou.api.v1;

import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.model.Category;
import com.lin.missyou.model.GridCategory;
import com.lin.missyou.service.CategoryService;
import com.lin.missyou.service.GridCategroyService;
import com.lin.missyou.vo.CategoriesAllVO;
import com.lin.missyou.vo.CategoryPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * web项目必须要精准的返回数据
 */
@RequestMapping("category")
@RestController
@ResponseBody
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GridCategroyService gridCategroyService;

    @RequestMapping("/all")
    public CategoriesAllVO  getAll(){

        Map<Integer, List<Category>> categories = categoryService.getAll();

        return new CategoriesAllVO(categories);
    }

/**
 * 合并到一起没有必须要爆出那么多的controller
 */
    @RequestMapping("grid/all")
    public List<GridCategory>  getCategoryList(){
        List<GridCategory> gridCategoryList = gridCategroyService.getGridCategoryList();
        if(gridCategoryList.isEmpty()){
            throw new NotFoundException(30009);
        }
        return gridCategoryList;
    }


}

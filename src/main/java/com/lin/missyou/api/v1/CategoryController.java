package com.lin.missyou.api.v1;

import com.lin.missyou.model.Category;
import com.lin.missyou.service.CategoryService;
import com.lin.missyou.vo.CategoriesAllVO;
import com.lin.missyou.vo.CategoryPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("category")
@RestController
@ResponseBody
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/all")
    public CategoriesAllVO  getAll(){

        Map<Integer, List<Category>> categories = categoryService.getAll();

        return new CategoriesAllVO(categories);
    }




}

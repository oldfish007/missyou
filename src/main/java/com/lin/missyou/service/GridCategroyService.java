package com.lin.missyou.service;

import com.lin.missyou.model.GridCategory;
import com.lin.missyou.repository.GridCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategroyService {

    @Autowired
    private GridCategoryRepository categoryRepository;


    public List<GridCategory> getGridCategoryList(){
        return categoryRepository.findAll();
    }
}

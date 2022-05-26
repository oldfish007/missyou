package com.lin.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.lin.missyou.model.Theme;
import com.lin.missyou.service.ThemeService;
import com.lin.missyou.vo.ThemePureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("theme")
@Validated
public class ThemeController {

    @Autowired
    private ThemeService themeService;
/**
 * 创建一个pureVO
 */
    @GetMapping("/by/names")
    public List<ThemePureVO> getThemeGroupByNames(@RequestParam(name="names") String names){
        List<String> nameList = Arrays.asList(names.split(","));
        List<Theme> themes = themeService.findbyNames(nameList);
        ArrayList<ThemePureVO>  list = new ArrayList<>();
        //对象对拷
        themes.forEach(theme -> {
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            ThemePureVO themePureVO = mapper.map(theme,ThemePureVO.class);
            list.add(themePureVO);
        });
        return list;
    }
}

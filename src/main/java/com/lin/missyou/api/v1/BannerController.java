package com.lin.missyou.api.v1;

import com.lin.missyou.dto.PersonDTO;
import com.lin.missyou.exception.http.ForbiddenException;
import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.model.Banner;
import com.lin.missyou.sampile.ISkill;
import com.lin.missyou.service.BannerService;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {


    @Autowired
    private ISkill iSkill;
    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public Banner  getByName(@PathVariable @NotBlank String name){
        Banner banner =  bannerService.getByName(name);
        if(banner==null){
            throw new NotFoundException(30005);
        }
        return banner;
    }

    @GetMapping("/test")
    public String test() throws Exception {
        iSkill.r();
        throw new ForbiddenException(10000) ;
        //throw new RuntimeException("这里错了");
        //return "Hello,九月";  抛出异常也算是处理异常了
    }

    //@RequestMapping(value = "/test/{id}",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
    @PostMapping("/test/{id}")
    public PersonDTO test(@PathVariable(name="id") @Range(min=1,max = 10,message="不可以超过10哦") Integer id,
                     @RequestParam @Length(min=8)  String name,
                     @RequestBody @Validated  PersonDTO personDTO){
        //PersonDTO p = new PersonDTO(personDTO.getName(),personDTO.getAge());
        PersonDTO dto = PersonDTO.builder().name("zhangsan").age("123").build();
        return dto;
    }



}

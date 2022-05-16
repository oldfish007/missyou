package com.lin.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.lin.missyou.bo.PageCounter;
import com.lin.missyou.dto.PersonDTO;
import com.lin.missyou.exception.http.ForbiddenException;
import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.model.Banner;
import com.lin.missyou.model.Spu;
import com.lin.missyou.sampile.ISkill;
import com.lin.missyou.service.BannerService;
import com.lin.missyou.service.SpuService;
import com.lin.missyou.util.CommonUtil;
import com.lin.missyou.vo.Paging;
import com.lin.missyou.vo.PagingDozer;
import com.lin.missyou.vo.SpuSimplifyVO;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping("/spu")
@Validated
public class SpuController {


    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu  getDetal(@PathVariable @Positive(message="{id.positive}") Long id){
        Spu spu = this.spuService.getSpu(id);
        if(spu==null){
            throw new NotFoundException(40001);
        }
        return spu;
    }

  /*
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
*/

    /**
     * 此处的message如何写到配置文件里面去
     * @param id
     * @return
     */
    @GetMapping("/id/{id}/simplify")
    public SpuSimplifyVO  getSimplifySpu(@PathVariable @Positive(message="{id.positive}") Long id){
        Spu spu = this.spuService.getSpu(id);
        SpuSimplifyVO vo = new SpuSimplifyVO();
        BeanUtils.copyProperties(spu,vo);
        return vo;
    }

    /**
     * spu
     * @return
     */

    @GetMapping("/latest")
    public PagingDozer<Spu, SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue = "0") Integer page,
                                                             @RequestParam(defaultValue = "10") Integer count){
        /*
        PageCounter pageCounter = CommonUtil.convertToPageParameter(page, count);
        Page<Spu> spuList = this.spuService.getLatestPagingSpu(pageCounter.getPage(), pageCounter.getCount());
        Paging<Spu> paging = new Paging<>(spuList);
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<SpuSimplifyVO> vos = new ArrayList<>();
//原数据的类型是s,目标数据的类型SpuSimplifyVO
        spuList.forEach(s->{
           SpuSimplifyVO vo =  mapper.map(s,SpuSimplifyVO.class);
           vos.add(vo);
        });
        return this.spuService.getLatestPagingSpu();
        */
        PageCounter pageCounter = CommonUtil.convertToPageParameter(page, count);
        Page<Spu> p = this.spuService.getLatestPagingSpu(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(p,SpuSimplifyVO.class);
    }

    @GetMapping("/by/category/{id}")
    public PagingDozer<Spu,SpuSimplifyVO> getByCategoryId(@PathVariable  @Positive Long id,
                                                        @RequestParam(name="is_root",defaultValue = "false")Boolean isRoot,
                                                        @RequestParam(name="start",defaultValue = "0") Integer start,
                                                        @RequestParam(name="count",defaultValue = "10") Integer count
                                                        ){
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> page = this.spuService.getByCategory(id,isRoot,pageCounter.getPage(),pageCounter.getCount());
        return new PagingDozer<>(page,SpuSimplifyVO.class);
    }

}

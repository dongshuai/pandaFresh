package com.pf.app.api.service;

import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfCategoryMapper;
import com.pf.app.api.model.PfCategory;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.CategoryVo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
@Service
@ReadOnly
public class CategoryListService extends AbstractService<CategoryVo>{
    @Resource
    private PfCategoryMapper pfCategoryMapper;

    @Override
    public InterfaceResponse check(CategoryVo vo) {
        return null;
    }

    @Override
    public InterfaceResponse executor(CategoryVo vo) {
        Long pid = vo.getPid();
        if(pid==null){
            pid= 0L;
        }

        Example example = new Example(PfCategory.class);
        example.createCriteria().andEqualTo("pid",pid);
        example.orderBy("seq").asc();
        List<PfCategory> pfCategoryList = pfCategoryMapper.selectByExample(example);
        return success(pfCategoryList);
    }
}

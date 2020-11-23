package com.leyou.item.service.impl;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private CategoryMapper categoryMapper;

    /**
     * 根据父节点查询所有分类
     * @param pid
     * @return
     */
    @Override
    public List<Category> queryCategoriesByPid(long pid) {
        Category category = new Category();
        category.setId(pid);
        return categoryMapper.select(category);
    }
}

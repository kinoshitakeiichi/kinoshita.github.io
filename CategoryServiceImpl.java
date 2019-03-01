package com.itheima.core.service.impl;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.common.utils.Page;
import com.itheima.core.dao.CategoryDao;
import com.itheima.core.dao.GoodsDao;
import com.itheima.core.po.Category;
import com.itheima.core.po.Goods;
import com.itheima.core.service.CategoryService;
import com.itheima.core.service.GoodsService;
/**
 * 商品分类管理
 */
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
	// 声明DAO属性并注入
	@Autowired
	private CategoryDao categoryDao;

	//商品分类列表
	@Override
	public List<Category> findCateList() {
		List<Category> list=categoryDao.selectCateList();
//		System.out.println("===list======"+list);
		return list;
	}

	@Override
	public List<Category> findParentCateList() {
		List<Category> list=categoryDao.selectParentCateList();
//		System.out.println("===list======"+list);
		return list;
	}

	@Override
	public int createCategory(Category cate) {
		
		return categoryDao.createCategory(cate);
	}
    //根据id获取商品分类信息
	@Override
	public Category getCateById(Integer id) {
		Category category = categoryDao.getCateById(id);
		    return category;	
	}
    //更新商品分类信息
	@Override
	public int updateCate(Category category) {
		System.out.println("======category==="+category);
		 return categoryDao.updateCate(category);
	}
    //删除商品分类信息
	@Override
	public int deleteCate(Integer cate_id) {
		return categoryDao.deleteCate(cate_id);	
	}

	
}

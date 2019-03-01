package com.itheima.core.service;
import java.util.List;

import com.itheima.common.utils.Page;
import com.itheima.core.po.Category;
import com.itheima.core.po.Goods;
public interface CategoryService {

	
	//商品分类列表
	public List<Category> findCateList();
	//一级分类
	public List<Category> findParentCateList();
	//创建分类
	public int createCategory(Category cate);
	//通过id获取商品分类信息
	public Category getCateById(Integer id);
	//更新商品分类
	public int updateCate(Category category);
	
	//删除商品分类信息
	public int deleteCate(Integer cate_id);
	


}

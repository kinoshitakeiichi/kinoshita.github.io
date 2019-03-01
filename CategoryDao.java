package com.itheima.core.dao;
import java.util.List;

import com.itheima.core.po.Category;
import com.itheima.core.po.Goods;
/**
 * Category接口
 */
public interface CategoryDao {
	
	//商品分类列表
	public List selectCateList();

	public List<Category> selectParentCateList();
    //创建商品分类
	public int createCategory(Category cate);
	//通过id获取商品分类信息
	public Category getCateById(Integer id);
	//更新商品分类信息
	public int updateCate(Category category);
	//删除商品分类信息
	public int deleteCate(Integer cate_id);


}

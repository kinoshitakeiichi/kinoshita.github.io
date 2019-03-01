package com.itheima.core.web.controller;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.core.po.Category;
import com.itheima.core.po.Goods;
import com.itheima.core.po.User;
import com.itheima.core.service.CategoryService;
import com.itheima.core.service.GoodsService;
/**
 * 商品分类管理控制器类
 */
@Controller
public class CategoryController {
	// 依赖注入
	@Autowired
	private CategoryService categoryService;


	/**
	 *  商品分类列表
	 */
	@RequestMapping(value = "/category/list.action")
	public String list( Model model) {
		
		//商品分类列表
        //一级分类
		List<Category> catelist1=categoryService.findParentCateList();
		model.addAttribute("catelist1", catelist1);	
		//二级分类
		List<Category> catelist2=categoryService.findCateList();
		model.addAttribute("catelist2", catelist2);	

		return "category_list";

	}
	
	/**
	 * 创建商品分类
	 */
	@RequestMapping("/category/create.action")
	@ResponseBody
	public String cateCreate(Category cate,HttpSession session) {

	    // 执行Service层中的创建方法，返回的是受影响的行数
	    int rows = categoryService.createCategory(cate);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 通过id获取商品分类信息
	 */
	@RequestMapping("/category/getCateById.action")
	@ResponseBody
	public Category getCateById(Integer cate_id) {
		 
	    Category cate = categoryService.getCateById(cate_id);
	 
	    return cate;
	}
	
	/**
	 * 更新商品分类
	 */
	@RequestMapping("/category/update.action")
	@ResponseBody
	public String cateUpdate(Category category) {
		   System.out.println("======="+category);
	    int rows = categoryService.updateCate(category);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}

	/**
	 * 删除商品分类信息
	 */
	@RequestMapping("/category/delete.action")
	@ResponseBody
	public String cateDelete(Integer cate_id) {
	    int rows = categoryService.deleteCate(cate_id);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
}

package com.itheima.core.service;
import java.util.List;

import com.itheima.common.utils.Page;
import com.itheima.core.po.Category;
import com.itheima.core.po.Goods;
public interface GoodsService {
	// 查询客户列表
	public Page<Goods> findGoodsList(Integer page, Integer rows);
	
	//商品分类列表
	public List<Category> findCateList();
	
//	public int createCustomer(Customer customer);
//	
//	// 通过id查询客户
//	public Customer getCustomerById(Integer id);
//	// 更新客户
//	public int updateCustomer(Customer customer);
//	// 删除客户
//	public int deleteCustomer(Integer id);

}

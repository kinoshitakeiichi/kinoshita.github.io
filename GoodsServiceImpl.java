package com.itheima.core.service.impl;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.common.utils.Page;
import com.itheima.core.dao.GoodsDao;
import com.itheima.core.po.Category;
import com.itheima.core.po.Goods;
import com.itheima.core.service.GoodsService;
/**
 * 商品管理
 */
@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {
	// 声明DAO属性并注入
	@Autowired
	private GoodsDao goodsDao;
	// 商品信息列表
	public Page<Goods> findGoodsList(Integer page, Integer rows) {
		// 创建商品对象
         Goods good = new Goods();

		// 当前页
		good.setStart((page-1) * rows) ;
		// 每页数
		good.setRows(rows);
		// 查询商品列表
		List<Goods> goods = 
                            goodsDao.selectGoodsList(good);
		// 查询商品列表总记录数
		Integer count = goodsDao.selectGoodsListCount(good);
		// 创建Page返回对象
		Page<Goods> result = new Page<>();
		result.setPage(page);
		result.setRows(goods);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}
	
	//商品分类列表
	@Override
	public List<Category> findCateList() {
		List<Category> list=goodsDao.selectCateList();
		System.out.println("===list======"+list);
		return list;
	}

	
}

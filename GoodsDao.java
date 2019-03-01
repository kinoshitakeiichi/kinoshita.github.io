package com.itheima.core.dao;
import java.util.List;

import com.itheima.core.po.Goods;
/**
 * Goods接口
 */
public interface GoodsDao {
    // 商品列表
	public List<Goods> selectGoodsList(Goods good);
	// 商品数
	public Integer selectGoodsListCount(Goods good);
	
	//商品分类列表
	public List selectCateList();


}

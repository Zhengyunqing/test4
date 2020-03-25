package com.bobo.goods.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bobo.goods.domain.Good;
import com.bobo.goods.domain.Shop;

public interface ShopService {
	
	/**
	 * 
	 * @Title: select 
	 * @Description: 查询单个店铺
	 * @param sid
	 * @return
	 * @return: Shop
	 */
	Shop select(Integer sid);
	
	/**
	 * 
	 * @Title: insertShop 
	 * @Description: 增加店铺
	 * @return
	 * @return: int
	 */
	boolean insertShop(Shop shop,Integer[] gids);

	/**
	 * 
	 * @Title: selects 
	 * @Description: 商铺列表
	 * @return
	 * @return: List<Shop>
	 */
	List<Shop> selects(Integer[] gids,String name);
	
	/**
	 * 
	 * @Title: selectGooods 
	 * @Description: 查询所有商品
	 * @return
	 * @return: List<Good>
	 */
	List<Good> selectGooods();
}

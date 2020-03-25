package com.bobo.goods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bobo.goods.domain.Good;
import com.bobo.goods.domain.Shop;

public interface ShopMapper {
	/**
	 * 
	 * @Title: selects 
	 * @Description: TODO
	 * @param gids商品的id 
	 * @param name 店面的名称
	 * @return
	 * @return: List<Shop>
	 */
	List<Shop> selects(@Param("gids")Integer[] gids,@Param("name")String name);

	/**
	 * 
	 * @Title: selectGooods 
	 * @Description: 查询所有商品
	 * @return
	 * @return: List<Good>
	 */
	List<Good> selectGoods();
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加商铺
	 * @param shop
	 * @return
	 * @return: int
	 */
	int insert(Shop shop);
	/**
	 * 
	 * @Title: insertMiddle 
	 * @Description: 增加中间表
	 * @param sid 店铺ID
	 * @param gids 商品iD
	 * @return
	 * @return: int
	 */
	int insertMiddle(@Param("sid")Integer sid,@Param("gids")Integer[] gids);
	
	/**
	 * 
	 * @Title: select 
	 * @Description: 查询单个店铺
	 * @param sid
	 * @return
	 * @return: Shop
	 */
	Shop select(Integer sid);
}

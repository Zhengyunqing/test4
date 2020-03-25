package com.bobo.goods.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bobo.goods.dao.ShopMapper;
import com.bobo.goods.domain.Good;
import com.bobo.goods.domain.Shop;
import com.bobo.goods.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	@Resource
	ShopMapper shopMapper;

	@Override
	public List<Shop> selects(Integer[] gids,String name) {
		// TODO Auto-generated method stub
		return shopMapper.selects(gids,name);
	}

	@Override
	public List<Good> selectGooods() {
		// TODO Auto-generated method stub
		return shopMapper.selectGoods();
	}

	@Override
	public boolean insertShop(Shop shop, Integer[] gids) {
		try {
			//1.增加店铺
			
			shopMapper.insert(shop);
			//2.增加中间表
			shopMapper.insertMiddle(shop.getId(), gids);
			return true;
		  } catch (Exception e) {
			 e.printStackTrace(); 
			 throw new RuntimeException("创建店铺失败"); //事务回滚
		}
		
	}

	@Override
	public Shop select(Integer sid) {
		// TODO Auto-generated method stub
		return shopMapper.select(sid);
	}

}

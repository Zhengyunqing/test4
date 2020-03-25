package com.bobo.goods.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: Item 
 * @Description: TODO
 * @author: charles
 * @date: 2020年3月20日 上午11:41:15
 */
public class Good implements Serializable{

	private Integer  id;
	private String name;
	
	private List<Shop> shops;
	
	
	
	public List<Shop> getShops() {
		return shops;
	}
	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

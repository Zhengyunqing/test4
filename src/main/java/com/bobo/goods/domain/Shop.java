package com.bobo.goods.domain;
/**
 * 
 * @ClassName: Shop 
 * @Description: TODO
 * @author: charles
 * @date: 2020年3月20日 上午11:43:16
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Shop  implements Serializable{
	private  Integer id;//主键
	private String name;
	
	
	private String picture;//店面 图片
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created;
	
	private List<Good> goods;//商品
	
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public List<Good> getGoods() {
		return goods;
	}
	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
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

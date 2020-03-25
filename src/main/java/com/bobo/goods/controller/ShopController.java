package com.bobo.goods.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * 
 * @ClassName: ShopController 
 * @Description: TODO
 * @author: charles
 * @date: 2020年3月21日 上午8:58:52
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bobo.goods.domain.Good;
import com.bobo.goods.domain.Shop;
import com.bobo.goods.service.ShopService;

@Controller
public class ShopController {

	@Resource
	private ShopService shopService;

	/**
	 * 
	 * @Title: shops
	 * @Description: 商铺列表
	 * @param model
	 * @return
	 * @return: String gids =1,2
	 */
	@RequestMapping("shops")
	public String shops(Model model, String gids, String name) {
		Integer[] ids = null;
		if (gids != null && gids.length() > 0) {
			String[] split = gids.split(",");
			ids = new Integer[split.length];
			for (int i = 0; i < split.length; i++) {
				ids[i] = Integer.parseInt(split[i]);
			}
		}
		List<Shop> shops = shopService.selects(ids, name);
		model.addAttribute("shops", shops);
		model.addAttribute("name", name);// 封装查询条件
		model.addAttribute("gids", gids);// 封装查询条件

		return "shops";

	}

	/**
	 * 
	 * @Title: add
	 * @Description: 去增加， 只支持get请求
	 * @return
	 * @return: String
	 */
	@GetMapping("add")
	public String add() {

		return "add";
	}

	/**
	 * 
	 * @Title: selectGoods
	 * @Description: 返回所有商品
	 * @return
	 * @return: List<Good>
	 */
	@ResponseBody
	@GetMapping("selectGoods")
	public List<Good> selectGoods() {
		return shopService.selectGooods();
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 执行增加，只支持post请求
	 * @param shop
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@PostMapping("add")
	public boolean add(Shop shop, Integer[] gids, MultipartFile file) {
		if (null != file && !file.isEmpty()) {	// 判断文件是否为空
			String path = "e:/pic/";// 文件上传的路径
			// a.jpg 文件的原始名称
			String oldFile = file.getOriginalFilename();
			// 为了防止文件重复，需要改变文件的上传名称，改成uuid 的方式
			String fileName = UUID.randomUUID() + oldFile.substring(oldFile.lastIndexOf("."));
			//根据路径和文件名称创建一个空的文件对象
			File f = new File(path,fileName);
			try {
				file.transferTo(f);
				shop.setPicture(fileName);//把文件名称赋值给商铺的属性
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return shopService.insertShop(shop, gids);
	}

	/**
	 * 
	 * @Title: detail
	 * @Description: 店铺详情
	 * @return
	 * @return: String
	 */
	@GetMapping("/detail")
	public String detail(Integer id, Model model) {
		model.addAttribute("shop", shopService.select(id));
		return "shop";
	}
}

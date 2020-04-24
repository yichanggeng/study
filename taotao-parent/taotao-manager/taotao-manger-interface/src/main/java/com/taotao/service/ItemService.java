package com.taotao.service;

import com.taotao.pojo.TbItem;

/**
 * 商品信息类
 * @author Administrator
 *
 */
public interface ItemService {

	/**
	 * 根据商品id获取商品情况
	 * @param itemId
	 * @return
	 */
	TbItem getItemById( long itemId );
	
	
	
	
	
}

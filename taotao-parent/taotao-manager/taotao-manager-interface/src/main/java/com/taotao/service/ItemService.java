package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
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
	
	/**
	 * 根据分页信息查询分页数据
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGridResult getItemList( int page , int rows ) ;
	
	/**
	 * 添加商品
	 * @param item
	 * @param desc  商品描述存储在量一张表中的
	 * @return
	 */
	TaotaoResult createItem( TbItem item , String desc);
	
	
	
	
}

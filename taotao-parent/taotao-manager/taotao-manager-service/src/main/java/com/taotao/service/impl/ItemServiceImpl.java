package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		return itemMapper.selectByPrimaryKey(itemId);
	}
	
	
	
}

package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		return itemMapper.selectByPrimaryKey(itemId);
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		
		// 设置分页信息
		PageHelper.startPage( page , rows );
		// 查询分页数据
		
		List<TbItem> list = itemMapper.selectByExample(null);
		// 组装分页返回数据
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows( pageInfo.getList() );
		result.setTotal( pageInfo.getTotal() );
		
		return result;
	}

	@Override
	public TaotaoResult createItem(TbItem item, String desc) {
		
		// 添加商品
		
		
		// 添加商品描述
		
		
		
		return null;
	}
	
	
	
}

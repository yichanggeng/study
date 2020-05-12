package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private TbItemCatMapper itemCatMapper;
	

	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		
		TbItemCatExample itemCatExample = new TbItemCatExample();
		Criteria criteria = itemCatExample.createCriteria();
		criteria.andParentIdEqualTo( parentId );
		List<TbItemCat> itemCatList = itemCatMapper.selectByExample(itemCatExample);
		
		List<EasyUITreeNode> treeList = new ArrayList<EasyUITreeNode>();
		EasyUITreeNode node = null;
		for( TbItemCat itemCat : itemCatList ) {
			
			node = new EasyUITreeNode();
			node.setId( itemCat.getId() );
			node.setText( itemCat.getName() );
			node.setState( itemCat.getIsParent() ? "closed" : "open" );
			
			treeList.add( node );
		}
		return treeList;
	}

}

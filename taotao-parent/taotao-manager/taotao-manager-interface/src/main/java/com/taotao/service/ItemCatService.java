package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;

/**
 * 商品分类服务
 * @author Administrator
 *
 */
public interface ItemCatService {

	/**
	 * 根据父id获取其下的商品分类树节点列表
	 * @param parentId
	 * @return
	 */
	List<EasyUITreeNode> getItemCatList( long parentId ); 
	
	
	
}

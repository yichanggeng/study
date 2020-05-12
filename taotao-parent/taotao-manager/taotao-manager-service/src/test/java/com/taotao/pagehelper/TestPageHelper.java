package com.taotao.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;

/**
 * 测试分页插件
 * @author Administrator
 *
 */
public class TestPageHelper {

	@Test
	public void testPageHelper() {
		
		// 配置分页大小
		PageHelper.startPage(1, 10);
		// 加载spring的配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext( "classpath:/spring/applicationContext-dao.xml" );
		
		// 获取操作数据库的bean对象
		TbItemMapper itemMapper = context.getBean( TbItemMapper.class );
		
		TbItemExample itemExample = new TbItemExample();
		
		Criteria criteria = itemExample.createCriteria();
		criteria.andNumIsNotNull();
		
		List<TbItem> list = itemMapper.selectByExample(itemExample);
		
		PageInfo<TbItem> page = new PageInfo<TbItem>(list);
		
		System.out.println( "total:" + page.getTotal() );
		System.out.println( "pageSize:" + page.getPageSize() );
		System.out.println( "pageNum:" + page.getPageNum() );
		
		
	}
	
	
	
	
}

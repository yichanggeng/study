package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * easyui中table的返回对象
 * @author Administrator
 *
 */
public class EasyUIDataGridResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2415404292705867968L;
	/**
	 * 总行数
	 */
	private long total;
	/**
	 * 每页的数据
	 */
	private List<?> rows;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}

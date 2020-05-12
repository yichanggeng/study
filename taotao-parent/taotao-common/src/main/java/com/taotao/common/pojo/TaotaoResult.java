package com.taotao.common.pojo;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 请求返回结果
 * @author Administrator
 *
 */
public class TaotaoResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6160265667691262547L;

	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	/**
	 * 状态码
	 */
	private Integer status;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 返回的数据
	 */
	private Object data;
	
	public static TaotaoResult build( Integer status , String msg , Object data ) {
		return new TaotaoResult(status, msg, data);
	}
	
	
	public static TaotaoResult build( Integer status , String msg ) {
		return new TaotaoResult(status, msg, null);
	}
	
	
	public static TaotaoResult formatToPojo( String jsonStr , Class<?> clazz ) {
		
		if( null == clazz ) {
			try {
				return MAPPER.readValue( jsonStr, TaotaoResult.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			JsonNode jsonNode = MAPPER.readTree( jsonStr );
			
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if( data.isObject() ){
				obj = MAPPER.readValue( data.traverse() , clazz);
			}else if( data.isTextual() ){
				obj = MAPPER.readValue( data.asText(), clazz );
			}
			
			return TaotaoResult.build(jsonNode.get("status").intValue() , jsonNode.get("message").asText() , obj );
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static TaotaoResult build( String jsonStr ) {
		try {
			return MAPPER.readValue( jsonStr, TaotaoResult.class );
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	public static TaotaoResult formatToList( String jsonStr , Class<?> clazz ) {
		try {
			JsonNode jsonNode = MAPPER.readTree( jsonStr );
			
			JsonNode data = jsonNode.get("data");
			
			Object obj = null;
			if( data.isArray() && data.size() > 0 ) {
				obj = MAPPER.readValue( data.traverse(), MAPPER.getTypeFactory().constructCollectionType(List.class, clazz) );
			}
			
			return TaotaoResult.build(jsonNode.get("status").intValue() , jsonNode.get("message").asText() , obj );
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	public TaotaoResult(Integer status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	
	public TaotaoResult(Object data) {
		this.status = 200;
		this.message = "OK";
		this.data = data;
	}





	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}

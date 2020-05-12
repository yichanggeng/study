package com.taotao.common.pojo;

import java.awt.SystemColor;
import java.util.Random;

/**
 * id生成工具
 */
public class IDUtils {

	/**
	 * 图片名称
	 * @return
	 */
	public static String genImageName() {
		
		long second = System.currentTimeMillis();
		
		Random random =  new Random(999);
		int randomNum = random.nextInt();
		
		return second + String.format("%03d", randomNum );
	}
	
	
	/**
	 * 生成商品id
	 * @return
	 */
	public static long genItemId() {
		
		long second = System.currentTimeMillis();
		
		Random random =  new Random(999);
		int randomNum = random.nextInt();
		
		return second << 2 + randomNum;
	}
	
	
	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		
		System.out.println( ( a << 3 )  + (a << 1) ); 
	}
	
}

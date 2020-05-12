package com.taotao.common.idempotent;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 幂等性aop处理
 * @author Administrator
 *
 */
@Aspect
@Component
public class IdempotentHandle {
	
	
	private static final Logger log = LoggerFactory.getLogger(IdempotentHandle.class);

	private final  String msg  ="token 失效，请刷新页面后再进行提交!";
	
	
	// redis操作模板
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
    private HttpServletRequest request;
	
	
	// 切点
	@Pointcut("@annotation(com.example.demo.retry.Idempotence)")
	public void idePoint() {
	}
	
	
	@Around("idePoint()")
	public Object around(ProceedingJoinPoint joinPoint) {
		
		// 前
		
		// 获取方法名
		String methodName = joinPoint.getSignature().getName();
		
		
		// 获取请求头中的token
		
		
		
		
		
		
		// 中
		
		
		
		// 后
		
		
		return null;
	}
	
	
	
	
	
	
}


/**
 * 
 * 尝试解决接口幂等性问题：
 * 方法有：
 * 1. aop ： 切点为自定义的注解，在@Around里面对token进行处理，@AfterThrow里面处理异常
 * 		优点： 只拦截特定加入了注解的请求方法，对其他方法无影响
 * 		缺点： 依赖于aop模块
 * 
 * 
 * 2. interceptor ： 拦截所有的方法，在handle中进行处理；
 * 		优点：不依赖与aop模块
 * 		缺点： 拦截了所有的请求；在handle中判断拦截是否需要处理；对不需要幂等性处理的接口增加了耗时
 * 
 */
/**
 * @author Administrator
 *
 */
package com.taotao.common.idempotent;
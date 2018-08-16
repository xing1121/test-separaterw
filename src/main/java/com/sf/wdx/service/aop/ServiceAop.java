package com.sf.wdx.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sf.wdx.router.KeyBinder;

@Component
public class ServiceAop {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Object bindDataSource(ProceedingJoinPoint pjd) {
		if (pjd == null) {
			return null;
		}
		// 获取方法签名
		Signature signature = pjd.getSignature();
		// 获取方法名
		String methodName = signature.getName();
		if (methodName == null || "".equals(methodName.trim())) {
			return null;
		}
		Object result = null;
		// 确定数据源
		boolean readOnly = methodName.startsWith("get") || methodName.startsWith("select") || methodName.startsWith("query") || methodName.startsWith("find");
		if (readOnly) {
			KeyBinder.bindKey(KeyBinder.DATASOURCE_3307);
		} else {
			KeyBinder.bindKey(KeyBinder.DATASOURCE_3306);
		}
		logger.info("ServiceAop...当前方法：" + methodName + "，绑定数据源：" + KeyBinder.getKey());
		try {
			result = pjd.proceed();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		} finally{
			logger.info("ServiceAop...finally...");
		}
		return result;
	}
	
}

package com.sf.wdx.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartUp {
	
	/**
	 * 测试MySQL的读写分离
	 *	@ReturnType	void 
	 *	@Date	2018年8月13日	下午3:32:52
	 *  @Param  @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-beans.xml");
		System.out.println("------------context" + context);
	}
	
}

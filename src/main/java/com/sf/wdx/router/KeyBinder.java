package com.sf.wdx.router;

public class KeyBinder {
	
	public static final String DATASOURCE_3306 = "DATASOURCE_3306";
	public static final String DATASOURCE_3307 = "DATASOURCE_3307";
	
	private static ThreadLocal<String> local = new ThreadLocal<>();

	//在线程ThreadLocal上绑定一个值Key
	public static void bindKey(String key) {
		local.set(key);
	}
	
	public static void removeKey() {
		local.remove();
	}
	
	public static String getKey() {
		return local.get();
	}
	
	/*public static void main(String[] args) {
	 * 	解释本类中的资源为什么都需要是静态的
	 * 	原因：不能每次调用方法时都创建新的对象，要保证local对象是同一个对象
		KeyBinder binder = new KeyBinder();
		binder.bindKey(DATASOURCE_3306);
		
		binder = new KeyBinder();
		binder.getKey();
	}*/

}
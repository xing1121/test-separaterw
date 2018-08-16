package com.sf.wdx.router;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MyRouter extends AbstractRoutingDataSource{

    /**
     * 路由器数据源如何决定当前具体的数据库操作该访问哪一个具体数据源？
                    通过protected abstract Object determineCurrentLookupKey();
                    方法的返回值作为targetDataSources指向的Map的键，从而获取具体数据源。
     */
    @Override
    protected Object determineCurrentLookupKey() {
        //1.从线程上获取之前绑定的键
        String key = KeyBinder.getKey();
        
        //2.从线程上将之前绑定的键立即移除
        KeyBinder.removeKey();
        
        //3.给Spring框架返回，让Spring框架据此判断该访问哪个数据库
        return key;
    }

}

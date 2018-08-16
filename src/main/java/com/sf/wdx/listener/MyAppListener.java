package com.sf.wdx.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sf.wdx.domain.Person;
import com.sf.wdx.service.PersonService;

/**
 * 描述：Spring启动监听器
 * @author 80002888
 * @date   2018年8月13日
 */
@Component
public class MyAppListener implements ApplicationListener<ApplicationEvent>{

	@Autowired
	private PersonService personService;
	
	/**
	 * Spring启动时触发(refresh=ContextRefreshedEvent，若是调用context.start()=ContextStartedEvent)
	 */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			// 查询-3307
			List<Person> persons = personService.selectAllPerson();
			persons.forEach(System.out::println);
			
			// 添加-3306
			personService.insert(new Person(null, "秦风", 33, "qf@126.com"));
			System.out.println("添加成功！");
			
			// 查询-3307
			persons = personService.selectAllPerson();
			persons.forEach(System.out::println);
		}
	}

}

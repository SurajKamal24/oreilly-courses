package com.oreilly.demo;

import com.oreilly.demo.controllers.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		int count = context.getBeanDefinitionCount();
		System.out.println("There are " + count + " beans in the application context");
		Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
	}

	@Test
	void getGreetingBean() {
		Greeting bean1 = context.getBean("greeting", Greeting.class);
		Greeting bean2 = context.getBean("greeting", Greeting.class);
		assertEquals(bean1, bean2);
		assertSame(bean1, bean2);
		//
 	}

}

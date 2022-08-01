package com.example.demo;

import java.time.LocalTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		Object byName = context.getBean("greeting");
		String byType = context.getBean(String.class);
		String byBoth = context.getBean("greeting", String.class);

		Object theName = context.getBean("getTime");
		Integer theType = context.getBean(Integer.class);
		Integer byBothz = context.getBean("getTime", Integer.class);
		

		System.out.println(byName);
		System.out.println(byType);
		System.out.println(byBoth);

		System.out.println(theName);
		System.out.println(theType);
		System.out.println(byBothz);
	}

	
	

	@Bean
	public String greeting() {
		return "Hello world";
	}

	

	@Bean
	public int getTime() {
		LocalTime  time = LocalTime.now();
		return time.getSecond();
	}



}

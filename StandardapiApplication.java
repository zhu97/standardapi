package com.zyl.standardapi;

import com.zyl.standardapi.common.processor.RequestCodeProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StandardapiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StandardapiApplication.class);
		/**
		 * 添加自定义注解监听器
		 */
		app.addListeners(new RequestCodeProcessor());
		app.run(args);
	}
}

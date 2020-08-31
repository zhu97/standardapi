package com.api;

import com.api.configure.RequestCodeListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zyl"})
public class StandardapiApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StandardapiApplication.class);
        /**
         * 添加自定义注解监听器
         */
        app.addListeners(new RequestCodeListener());
        app.run(args);
    }
}

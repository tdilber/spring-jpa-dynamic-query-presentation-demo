package com.beyt.presentation;

import com.beyt.jdq.annotation.EnableJpaDynamicQuery;
import com.beyt.jdq.annotation.EnableJpaDynamicQueryArgumentResolvers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@EnableJpaDynamicQuery
@EnableJpaDynamicQueryArgumentResolvers
@SpringBootApplication
public class SpringJpaDynamicQueryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDynamicQueryDemoApplication.class, args);
	}

}


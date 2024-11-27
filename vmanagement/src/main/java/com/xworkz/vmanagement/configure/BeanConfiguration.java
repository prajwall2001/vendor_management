package com.xworkz.vmanagement.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.vmanagement")
@EnableWebMvc
public class BeanConfiguration {
	public BeanConfiguration() {
		System.out.println("Created BeanConfiguration");
	}

	@Bean
	public ViewResolver viewResolver() {
		System.out.println("Invoking viewResolver().....");
		ViewResolver resolver = new InternalResourceViewResolver("/", ".jsp");
		return resolver;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		System.out.println("EntityManagerFactoryBean");
		return new LocalContainerEntityManagerFactoryBean();
	}

//	@Bean(name = "multipartResolver")
//	public CommonsMultipartResolver getCommonsMultipartResolver() {
//		System.out.println("Registering the multipart resolver in to spring");
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setMaxUploadSize(20971520); // 20MB
//		multipartResolver.setMaxInMemorySize(1048576); // 1MB
//		return multipartResolver;
//	}

}

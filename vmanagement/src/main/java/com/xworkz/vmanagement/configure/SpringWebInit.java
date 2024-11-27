package com.xworkz.vmanagement.configure;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Invoking getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Invoking getServletConfigClasses");
		return new Class[] { BeanConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Invoking getServletMappings");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/*
	 * @Override protected void customizeRegistration(Dynamic registration) { String
	 * tempDir = "‪D:\\temp";
	 * 
	 * int maxUploadSizeInMb = 3 * 1024 * 1024; File uploadDirectory = new
	 * File(tempDir); MultipartConfigElement multipartConfigElement = new
	 * MultipartConfigElement(uploadDirectory.getAbsolutePath(), maxUploadSizeInMb,
	 * maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
	 * 
	 * registration.setMultipartConfig(multipartConfigElement); }
	 */

}

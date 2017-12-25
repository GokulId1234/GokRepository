package com.scp.sort;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.scp.sort.common.ConstantsUtil;

/**
 * Spring boot application class
 * @author Gokul
 *
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableWebMvc
public class ScpSortApplication extends WebMvcConfigurerAdapter implements
		ApplicationContextAware {

	public static void main(String[] args) {
		SpringApplication.run(ScpSortApplication.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(ConstantsUtil.PATH_STATIC_TEMPLATE).addResourceLocations(
				ConstantsUtil.CLASSPATH);
	}

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(ScpSortApplication.class); }
	 */

}

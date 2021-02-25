package com.seleniumexpress.noteapp.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;




@Configuration
@EnableWebMvc
//@EnableTransactionManagement
@ComponentScan(basePackages= {"com.seleniumexpress.noteapp.controller","com.seleniumexpress.noteapp.service"})
public class NoteAppConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}
	
	@Bean
	DriverManagerDataSource  getDataSource()
	{
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("psswd name");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		return dataSource;
	}
	
	@Bean
	LocalSessionFactoryBean getLocalSessionFactoryBean()
	{
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDataSource());
		localSessionFactoryBean.setPackagesToScan("com.seleniumexpress.noteapp.model");
		
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
	
	    return localSessionFactoryBean;
	}

	
	public Properties getHibernateProperties()
	{
		Properties  hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.setProperty("hibernate.show.sql", "true");
		//hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		return hibernateProperties;
	}
	
	
	@Bean
	@Autowired
	HibernateTransactionManager getTransaction(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		
		return hibernateTransactionManager;
		
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/url/**")
		.addResourceLocations("/webapp/");

		registry.addResourceHandler("/urltoimg/**")
		.addResourceLocations("/webapp/img/");     //shorten image url
	}  
	


}

package com.mdtsoft.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class HibernateConfig implements TransactionManagementConfigurer{

	@Bean(destroyMethod = "close")
	public ComboPooledDataSource comboPooledDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/inccrm?useSSL=false");
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataSource.setUser("root");
		dataSource.setPassword("123456.");

		// These are connection pool properties for C3P0
		dataSource.setMinPoolSize(3);
		dataSource.setMaxPoolSize(20);
		dataSource.setMaxIdleTime(30000);

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(comboPooledDataSource());
		bean.setPackagesToScan("com.mdtsoft.model");

		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");

		bean.setHibernateProperties(properties);
		return bean;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		return hibernateTransactionManager;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}

}

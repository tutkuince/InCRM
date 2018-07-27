# InCRM - Customer Relationship Manager

**The aim of this project is to review basic CRUD processes with Spring framework and Hibernate ORM Tool.**

There are 7 layers in this project;
- config
	- **HibernateConfig:** Injected ComboPooledDataSource, LocalSessionFactoryBean and HibernateTransactionManager. PlatformTransactionManager is implementation of TransactionManagementConfigurer. Used c3p0 jar for hibernate connection pool.
	- **SpringConfig:** Injected ViewResolver. addResourceHandlers and addViewControllers methods are override from WebMvcConfigurer interface
	- **WebServletConfig:** implements WebApplicationInitializer for configuration with any servlets.
		
- controller
	- CustomerController
		
- dao
	- CustomerDAO
	- CustomerDAOImpl
		
- model
	- Customer
		
- service
	- CustomerService
	- CustomerServiceImpl
		
- test
	- TestDB: For checking JDBC connection. (JUnit)
		
- view
	- customer-from
	- index
	- list-customers
		
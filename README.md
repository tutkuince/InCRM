# InCRM - Customer Relationship Manager 1.1

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

## Update 1 - 08/03/2018:
- Aspect Oriented Programming
	- AOPExpressions.java for Pointcut declarations
	- CRMLoggingAspect.java for using @Before and @AfterReturning advices
	
**Additional information: "aspect" package was added after the project updated**

- aspect
	- AOPExpressions
	- CRMLoggingAspect

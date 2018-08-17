# InCRM - Customer Relationship Manager 1.2

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
	
## Update 2 - 08/14/2018:
- Spring REST
	- CustomerRestController.java for Controller using @RestController
	- CustomerErrorResponse.java is a pojo class.
	- CustomerNotFoundException extends RuntimeException
	- CustomerRestExceptionHandler for defining global exception handler using @ControllerAdvice
	
**Additional information: "rest" package was added after the project updated**

- aspect
	- error
		- CustomerErrorResponse
		- CustomerNotFoundException
		- CustomerRestExceptionHandler
	- CustomerRestController.java
	
## Update 3 - 08/17/2018:
- Secure REST APIs by Role
	- EMPLOYEE role can perform following
		- Get a list of all customers. GET /api/customers
		- Get a single customer. GET /api/customers/{customerId}
	- MANAGER role can perform following
		- Add a new customer. POST /api/customers
		- Update an existing customer. PUT /api/customers
	- ADMIN role can perform following
		- Delete a customer. DELETE /api/customers/{customerId}

- Authentication for Login page
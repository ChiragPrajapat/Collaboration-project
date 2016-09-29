package com.niit.collaborationbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.collaborationbackend.dao.BlogDAO;
import com.niit.collaborationbackend.dao.BlogDAOImpl;
import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.dao.UserDAOImpl;
import com.niit.collaborationbackend.model.Blog;
import com.niit.collaborationbackend.model.User;

@Configuration
@ComponentScan(basePackages = { "org.example.springproject" }, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) })

@ComponentScan("com.niit.collaborationbackend")
//@EnableTransactionManagement
//@EnableWebMvc
public class ApplicationContextConfig  {
	
    @Bean(name = "dataSource")
    public DataSource getOracleDataSource() {
    //	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	BasicDataSource dataSource= new BasicDataSource();
    	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
    	dataSource.setUsername("chiragdb");
    	dataSource.setPassword("password");
//    	Properties properties = new Properties();
//    	properties.setProperty("hibernate.hbm2ddl.auto","update");
//    	properties.setProperty("hibernate.show_sql", "true");
//    	properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//    	properties.setProperty("hibernate.format_sql","true");
////    	dataSource.setConnectionProperties(properties);
//  	dataSource.set(getHibernateProperties());
    	return dataSource;
    }
    private Properties getHibernateProperties()
    {
    	Properties properties = new Properties();
    	properties.setProperty("hibernate.hbm2ddl.auto","update");
    	properties.setProperty("hibernate.show_sql", "true");
    	properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
    	properties.setProperty("hibernate.format_sql","true");
    	return properties;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClass(User.class);
    	sessionBuilder.addAnnotatedClass(Blog.class);
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
	
//@Autowired
//@Bean(name="defaultServletHandlerMapping")
//public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configure){
//	configure.enable();
//}

	@Autowired
    @Bean(name = "userDAO")
	    public UserDAO getUserDAO(SessionFactory sessionFactory) {
	    	return new UserDAOImpl(sessionFactory);
	    }
	
	@Autowired
    @Bean(name = "blogDAO")
	    public BlogDAO getBlogDAO(SessionFactory sessionFactory) {
	    	return new BlogDAOImpl(sessionFactory);
	    }
}

package com.niit.collaborationbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.dao.UserDAOImpl;
import com.niit.collaborationbackend.model.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.niit"})
@EnableTransactionManagement
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {
    @Bean(name = "dataSource")
    public DataSource getOracleDataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
    	dataSource.setUsername("chiragdb");
    	dataSource.setPassword("password");
    	
    	dataSource.setConnectionProperties(getHibernateProperties());
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
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
	configurer.enable();
}

	 @Autowired
    @Bean(name = "userDao")
	    public UserDAO getCategorDao(SessionFactory sessionFactory) {
	    	return new UserDAOImpl(sessionFactory);
	    }

}

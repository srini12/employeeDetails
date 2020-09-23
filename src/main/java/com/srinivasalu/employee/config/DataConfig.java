package com.srinivasalu.employee.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Configuration
public class DataConfig {
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.datsource")
	public DataSource getDataSource() {
		 DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
	        dataSourceBuilder.url("jdbc:mysql://localhost:3306/MyEmployeeDB");
	        dataSourceBuilder.username("root");
	        dataSourceBuilder.password("test123");
	        return dataSourceBuilder.build();	
	}
}

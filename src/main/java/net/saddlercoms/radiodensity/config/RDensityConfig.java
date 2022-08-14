package net.saddlercoms.radiodensity.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RDensityConfig {

	private final Logger logger = LoggerFactory.getLogger(RDensityConfig.class);
	
	@Bean
	public DataSource dataSource() {
	    return DataSourceBuilder
	        .create()
	        .username("postgres")
	        .password("password")
	        .url("jdbc:postgresql://localhost:5432/radio")
	        .driverClassName("org.postgresql.Driver")
	        .build();
	}
}

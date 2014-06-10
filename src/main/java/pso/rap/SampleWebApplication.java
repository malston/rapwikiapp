package pso.rap;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SampleWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleWebApplication.class, args);
	}


	@Value("${spring.datasource.url}")
	private String dataSourceUrl;

	@Value("${spring.driver.class}")
	private String driverClassName;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dataSourceUrl);
		dataSource.setUsername("app");
		dataSource.setPassword("app");
		return dataSource;
	}
}

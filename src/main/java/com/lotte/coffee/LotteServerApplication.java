package com.lotte.coffee;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@ComponentScan(basePackages = "com.lotte.coffee")
@MapperScan("com.lotte.coffee.mapper")
@EnableAutoConfiguration
public class LotteServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteServerApplication.class, args);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(datasource);
		Resource[] arrResource = new PathMatchingResourcePatternResolver()
	            .getResources("classpath:mappers/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(arrResource);
		
		return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
	}
}

package com.lotte.coffee.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class DatabaseConfig {
	public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(datasource);
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
						 						.getResources("classpath:/mappers/*Mapper.xml"));
		
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
	
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}

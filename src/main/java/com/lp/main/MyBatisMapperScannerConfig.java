package com.lp.main;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描mybatis的接口
 * 
 * @author 刘攀
 *
 */
@Configuration
// 因为这个对象的扫描，需要在MyBatisConfig的后面注入，所以加上下面的注解
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		// 获取之前注入的beanName为sqlSessionFactory的对象
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		// 指定xml配置文件的路径
		mapperScannerConfigurer.setBasePackage("com.lp.dao.impl");
		//mapperScannerConfigurer.setAnnotationClass(Mapper.class);
		return mapperScannerConfigurer;
	}
}

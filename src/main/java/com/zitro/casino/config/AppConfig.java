package com.zitro.casino.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.zitro.casino.core.CasinoPoolManager;
import com.zitro.casino.core.Game;
import com.zitro.casino.impl.Bingo;

@Configuration
//@ComponentScan("com.zitro.casino")
//@ComponentScan(basePackages = "com.zitro.casino")
@PropertySource("classpath:casino.properties")
public class AppConfig {
	
	
	@Bean
	static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}	
	
	@Bean
	public CasinoPoolManager manager() {
		CasinoPoolManager pool = new CasinoPoolManager();
		pool.setCorePoolSize(5);
		pool.setMaxPoolSize(10);
		pool.setWaitForTasksToCompleteOnShutdown(true);
		return pool;
	}

	@Bean Game bingo(){
		return new Bingo();
	}

}
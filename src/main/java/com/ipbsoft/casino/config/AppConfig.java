package com.ipbsoft.casino.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.ipbsoft.casino.factory.GameFactory;
import com.ipbsoft.casino.factory.PlayTaskFactory;
import com.ipbsoft.casino.factory.PlayerFactory;
import com.ipbsoft.casino.manager.CasinoPoolManager;

/**
 * Configuration annotation-based for the spring context
 * @author insalada
 *
 */
@Configuration
@ComponentScan(basePackages = "com.ipbsoft.casino")
@PropertySource("classpath:casino.properties")
//@PropertySource("file:src/main/resources/casino.properties")
public class AppConfig {
	
	@Value("${poolsize}")
	private int poolsize;
	@Value("${maxpoolsize}")
	private int maxPoolsize;
	
	@Bean
	static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}	
	
	@Bean
	public CasinoPoolManager manager() {
		CasinoPoolManager pool = new CasinoPoolManager();
		pool.setCorePoolSize(poolsize);
		pool.setMaxPoolSize(maxPoolsize);
		pool.setWaitForTasksToCompleteOnShutdown(true);
		return pool;
	}

	@Bean
	PlayerFactory playerFactory() {
		return new PlayerFactory();
	}
	
	@Bean
	GameFactory gameFactory() {
		return new GameFactory();
	}
	
	@Bean
	PlayTaskFactory taskFactory() {
		return new PlayTaskFactory();
	}
}
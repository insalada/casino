package com.zitro.casino.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import com.zitro.casino.core.CasinoPoolManager;
import com.zitro.casino.factory.GameFactory;
import com.zitro.casino.factory.PlayTaskFactory;
import com.zitro.casino.factory.PlayerFactory;

/**
 * Configuration annotation-based for the spring context
 * @author insalada
 *
 */
@Configuration
@ComponentScan(basePackages = "com.zitro.casino")
@PropertySource("classpath:casino.properties")
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
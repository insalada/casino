package com.zitro.casino.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.zitro.casino.CasinoPoolManager;
import com.zitro.casino.Player;

@Configuration
//@ComponentScan("com.zitro.casino")
@PropertySource("config.properties")
public class AppConfig {
	
//	@Bean
//    public Player player() {
//        return new Player(new BigDecimal("100"), 12000, "Bet356");
//    }
	
	@Bean
	static PropertySourcesPlaceholderConfigurer pspc() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(5);
		pool.setMaxPoolSize(10);
		pool.setWaitForTasksToCompleteOnShutdown(true);
		return pool;
	}
	
	@Bean
	public ThreadPoolTaskScheduler scheduler() {
		ThreadPoolTaskScheduler pool = new ThreadPoolTaskScheduler();
		pool.setPoolSize(5);
		//pool.setBeanName("scheduler");
		pool.setWaitForTasksToCompleteOnShutdown(true);
		return pool;
	}
	
	
	
	@Bean
	public CasinoPoolManager manager() {
		CasinoPoolManager pool = new CasinoPoolManager();
		pool.setCorePoolSize(5);
		pool.setMaxPoolSize(10);
		pool.setWaitForTasksToCompleteOnShutdown(true);
		return pool;
	}

}
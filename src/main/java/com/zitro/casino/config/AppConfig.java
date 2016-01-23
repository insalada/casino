package com.zitro.casino.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.zitro.casino.core.Bet;
import com.zitro.casino.core.CasinoPoolManager;
import com.zitro.casino.core.Game;
import com.zitro.casino.core.Player;
import com.zitro.casino.core.PlayerFactory;
import com.zitro.casino.impl.Bingo;
import com.zitro.casino.impl.Ruleta;

@Configuration
//@ComponentScan({ "com.zitro.casino.core"})
//@ComponentScan("com.zitro.casino")
@ComponentScan(basePackages = "com.zitro.casino")
//@ComponentScan(basePackages = {"com.zitro.**"})
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

	@Bean 
	Game bingo() {
		return new Bingo();
	}
	
	@Bean 
	Game ruleta() {
		return new Ruleta();
	}

	@Bean
	PlayerFactory factory() {
		return new PlayerFactory();
	}
	
	
	@Bean
	Bet bet() {
		return new Bet();
	}
	
	@Bean
	Player ivan() {
		return new Player("ivan", new BigDecimal("100"), 10000, 1000, "Bet356");
	}

}
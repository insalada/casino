package com.zitro.casino.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author insalada
 *
 */
public class PlayerFactory {
	
	@Autowired
	private ApplicationContext context;

	@Bean
	public Player generate(String name, String balance, long playingTime, long waitingTime, String provider) {
		//Create the bean based on given parameters
		Player player = new Player(name, balance, playingTime, waitingTime, provider);
		//Let's add the autowire capacity to the bean
		context.getAutowireCapableBeanFactory().autowireBean(player);
		return player;
	}
	

}

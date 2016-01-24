package com.zitro.casino.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.zitro.casino.core.Player;
import com.zitro.casino.core.Provider;

/**
 * Factory creator for the players
 * 
 * @author insalada
 *
 */
public class PlayerFactory {
	
	@Autowired
	private ApplicationContext context;

	/**
	 * Returns a bean based on the given parameters and wire to the context
	 * 
	 * @param name
	 * @param balance
	 * @param playingTime
	 * @param waitingTime
	 * @param provider
	 * @return
	 */
	@Bean
	public Player generate(String name, String balance, int playingTime, int waitingTime, Provider provider) {
		//Create the bean based on given parameters
		Player player = new Player(name, balance, playingTime, waitingTime, provider);
		//Let's add the autowire capacity to the bean
		context.getAutowireCapableBeanFactory().autowireBean(player);
		return player;
	}
	

}

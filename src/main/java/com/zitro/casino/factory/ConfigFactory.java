package com.zitro.casino.factory;

import org.springframework.context.annotation.Bean;

import com.zitro.casino.core.Config;

/**
 * Factory objects creator for the game config 
 * (Each game may have different configurations)
 * 
 * @author insalada
 *
 */
public class ConfigFactory {
	
	/**
	 * 
	 * @param name
	 * @param balance
	 * @param playingTime
	 * @param waitingTime
	 * @param provider
	 * @return
	 */
	@Bean
	public static Config create(int minBet, int maxBet) {
		return new Config(minBet, maxBet);
	}
	

}

package com.zitro.casino.impl;

import org.springframework.beans.factory.annotation.Value;

import com.zitro.casino.core.Config;
import com.zitro.casino.core.Game;

/**
 * Game implementation for BlackJack
 * 
 * @author insalada
 *
 */
public class Blackjack implements Game {
	@Value("${name.blackjack}")
	private String name;
	@Value("${prize.probability.blackjack}")
    private int prizeProbability;
	private Config config;
	
	/**
	 * Constructor based on the given configuration
	 * @param config
	 */
	public Blackjack(Config config) {
		this.config = config;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrizeProbability() {
		return prizeProbability;
	}
	
	public Config getConfig() {
		return config;
	}
}
	
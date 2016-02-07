package com.ipbsoft.casino.impl;

import org.springframework.beans.factory.annotation.Value;

import com.ipbsoft.casino.core.Config;
import com.ipbsoft.casino.core.Game;
/**
 * Game implementation for Poker
 * 
 * @author insalada
 *
 */
public class Poker implements Game {
	@Value("${name.poker}")
	private String name;
	@Value("${prize.probability.poker}")
    private int prizeProbability;
	private Config config;
	
	/**
	 * Constructor based on the given configuration
	 * @param config
	 */
	public Poker(Config config) {
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
	
package com.zitro.casino.impl;

import org.springframework.beans.factory.annotation.Value;

import com.zitro.casino.core.Config;
import com.zitro.casino.core.Game;
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
	
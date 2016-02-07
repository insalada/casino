package com.ipbsoft.casino.impl;

import org.springframework.beans.factory.annotation.Value;

import com.ipbsoft.casino.core.Config;
import com.ipbsoft.casino.core.Game;
/**
 * Game implementation for Slot
 * 
 * @author insalada
 *
 */
public class Slot implements Game {
	@Value("${name.slot}")
	private String name;
	@Value("${prize.probability.slot}")
    private int prizeProbability;
	private Config config;
	
	/**
	 * Constructor based on the given configuration
	 * @param config
	 */
	public Slot(Config config) {
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
	
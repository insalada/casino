package com.ipbsoft.casino.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import com.ipbsoft.casino.core.Config;
import com.ipbsoft.casino.core.Game;

/**
 * Game implementation for Bingo
 * @author insalada
 *
 */
@Scope("prototype")
public class Bingo implements Game {
	
	@Value("${name.bingo}")
	private String name;
	@Value("${prize.probability.bingo}")
    private int prizeProbability;
	private Config config;
	
	public Bingo(Config config) {
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
	
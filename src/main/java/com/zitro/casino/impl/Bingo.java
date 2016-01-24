package com.zitro.casino.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import com.zitro.casino.core.Config;
import com.zitro.casino.core.Game;

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
	
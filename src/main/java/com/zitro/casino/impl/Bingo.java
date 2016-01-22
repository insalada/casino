package com.zitro.casino.impl;

import org.springframework.beans.factory.annotation.Value;

import com.zitro.casino.core.Game;

public class Bingo implements Game {
	
	
	@Value("${prize.probability.ruleta}")
    private int prizeProbability;
	@Value("${bet.min.ruleta}")
	private String betMinRuleta;
	@Value("${bet.max.ruleta}")
	private String betMaxRuleta;
	
	private String name = "RULETA";
	
	public Bingo() {
		super();
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrizeProbability() {
		return prizeProbability;
	}
}

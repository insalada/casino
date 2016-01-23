package com.zitro.casino.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zitro.casino.core.Game;

@Component
public class Bingo implements Game {
	
	@Value("${name.bingo}")
	private String name;
	@Value("${prize.probability.bingo}")
    private int prizeProbability;
	@Value("${bet.min.bingo}")
	private int betMin;
	@Value("${bet.max.bingo}")
	private int betMax;
	
	public String getName() {
		return name;
	}
	
	public int getPrizeProbability() {
		return prizeProbability;
	}

	public int getBetMin() {
		return betMin;
	}

	public int getBetMax() {
		return betMax;
	}
	
	

}
	
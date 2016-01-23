package com.zitro.casino.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zitro.casino.core.Game;

@Component
public class Ruleta implements Game {

	@Value("${name.ruleta}")
	private String name;
	@Value("${prize.probability.ruleta}")
    private int prizeProbability;
	@Value("${bet.min.ruleta}")
	private int betMin;
	@Value("${bet.max.ruleta}")
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

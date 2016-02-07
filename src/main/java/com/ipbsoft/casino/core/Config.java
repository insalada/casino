package com.ipbsoft.casino.core;

import org.springframework.context.annotation.Scope;

/**
 * Represents the Config objects required for the players game
 * 
 * @author insalada
 *
 */
@Scope("prototype")
public class Config {
	
	private int betMin;
	private int betMax;
	
	/**
	 * Constructor based on the minimum and maximal bet
	 * 
	 * @param betMin
	 * @param betMax
	 */
	public Config(int betMin, int betMax) {
		this.betMin = betMin;
		this.betMax = betMax;
	}
		
	public int getBetMin() {
		return betMin;
	}
	
	public int getBetMax() {
		return betMax;
	}
}

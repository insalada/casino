package com.zitro.casino;

import java.math.BigDecimal;
import java.util.UUID;

public class Game {

	private UUID uuid;
	private String name;
	private int probability;
	private BigDecimal minBet;
	private BigDecimal maxBet;
	
	
	public Game(String name, int probability, BigDecimal minBet, BigDecimal maxBet){
		this.name = name;
		this.probability = probability;
		this.minBet = minBet;
		this.maxBet = maxBet;
	}
	
}

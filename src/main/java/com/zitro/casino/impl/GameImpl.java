package com.zitro.casino.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zitro.casino.core.Game;

@Component
public class GameImpl implements Game{

	private UUID uuid;
	private String name;
	private int prizeProbability;
	private String minBet;
	private String maxBet;
	
	
	public GameImpl(String name, int prizeProbability, String minBet, String maxBet){
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.prizeProbability = prizeProbability;
		this.minBet = minBet;
		this.maxBet = maxBet;		
	}


	public UUID getUuid() {
		return uuid;
	}


	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getPrizeProbability() {
		return prizeProbability;
	}


	public void setPrizeProbability(int prizeProbability) {
		this.prizeProbability = prizeProbability;
	}


	public String getMinBet() {
		return minBet;
	}


	public void setMinBet(String minBet) {
		this.minBet = minBet;
	}


	public String getMaxBet() {
		return maxBet;
	}


	public void setMaxBet(String maxBet) {
		this.maxBet = maxBet;
	}


	
	
	
}

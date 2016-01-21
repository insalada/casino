package com.zitro.casino;

import java.math.BigDecimal;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {

	private UUID uuid;
	private String name;
	private BigDecimal balance;
	private long playingTime;
	private long waitingTime; //property
	private String provider;
	private final Logger LOGGER = LogManager.getLogger(Player.class);
	
	
	
	public Player(String name, BigDecimal balance, long playingTime, long waitingTime, String provider) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.balance = balance;
		this.waitingTime = waitingTime;
		this.playingTime = playingTime;
		this.provider = provider;
		System.out.println("Player generated from provider " + provider);
	}
	
	public void bet(){
		
		//1. Let's bet
		System.out.println(name + " bets");
		//2. Check if user wins
		//System.out.println("Did he win? " + false);
		//3. Update users balance
		//System.out.println("Balance updated. Current balance: " + balance);
	
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public long getPlayingTime() {
		return playingTime;
	}

	public void setPlayingTime(long playingTime) {
		this.playingTime = playingTime;
	}

	public long getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(long waitingTime) {
		this.waitingTime = waitingTime;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
	
}

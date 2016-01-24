package com.zitro.casino.core;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Represents each casinos player
 * 
 * @author insalada
 *
 */
@Component
@Scope("prototype")
public class Player {

	private UUID uuid;
	private String name;
	private BigDecimal balance;
	private long playingTime;
	private long waitingTime; //property
	private Provider provider;
	private Game game;
			
	/**
	 * Players constructor
	 * 
	 * @param name 
	 * @param balance initial credit
	 * @param playingTime in seconds
	 * @param waitingTime in seconds
	 * @param provider the user comes from
	 */
	public Player(String name, String balance, int playingTime, int waitingTime, Provider provider) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.balance = new BigDecimal(balance);
		this.waitingTime = waitingTime;
		this.playingTime = playingTime;
		this.provider = provider;
		System.out.println("Player " + uuid + " generated from provider " + provider);
	}
	

	public UUID getUuid() {
		return uuid;
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

	public long getWaitingTime() {
		return waitingTime;
	}

	public Provider getProvider() {
		return provider;
	}

	public String getName() {
		return name;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}


}

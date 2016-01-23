package com.zitro.casino.core;

import java.math.BigDecimal;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@Scope("prototype")
public class Player {

	private final Logger LOGGER = LogManager.getLogger(Player.class);
	private UUID uuid;
	private String name;
	private BigDecimal balance;
	private long playingTime;
	private long waitingTime; //property
	private String provider;
	private Game game;
	
	@Autowired
	private Bet bet;
	
	//remove
	public Player(){
		//System.out.println("bet in construc: " + bet);
		System.out.println("player normal constructor");
	}
		
	public Player(String name, String balance, long playingTime, long waitingTime, String provider) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.balance = new BigDecimal(balance);
		this.waitingTime = waitingTime;
		this.playingTime = playingTime;
		this.provider = provider;
		System.out.println("Player " + uuid + " generated from provider " + provider);
	}
	
	public void play(){
		
		//Let us play
		System.out.println("---------------");
				
		//User makes a bet
		int betAmount = bet.randomBet(game.getBetMin(), game.getBetMax());
		System.out.println(name + ": bets " + betAmount);
		
		
		//Check whether the bet is within the bounds
		if(betAmount < game.getBetMin() && betAmount > game.getBetMax()) {
			System.out.println(name + ": Incorrect bet. Please bet between " + game.getBetMin() + " and " + game.getBetMax());
			return;
		}
		
		//Check whether the user has enough credit
		if(balance.compareTo(new BigDecimal(betAmount)) < 0) {
			System.out.println(name + ": Insufficient funds. Your current balance is " + formatBalance());
			return;
		}
		
		
		//Check whether the user win
		boolean isWinner = bet.isLucky(game.getPrizeProbability());
		System.out.println(name + ": Did the player win the prize? " + isWinner);
		
		//Update the balance
		updateBalance(betAmount, isWinner);
		System.out.println(name + ": balance is " + formatBalance());
		

	
	}
	
	/**
	 * Add or Substract funds from the players credit 
	 * @param isWinner
	 */
	private void updateBalance(int betAmount, boolean isWinner) {
		if(isWinner) {
			balance = balance.add(new BigDecimal(betAmount));
		}else {
			balance = balance.subtract(new BigDecimal(betAmount));
		}
	}
	
	private String formatBalance() {
		return balance.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	
	
	

	
	
}

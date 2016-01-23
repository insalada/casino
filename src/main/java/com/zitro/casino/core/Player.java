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
	@Autowired
	private Jackpot jackpot;
	
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
						
		//User makes a bet
		int betAmount = bet.randomBet(game.getBetMin(), game.getBetMax());
		
		//Pass validations
		if(!validBet(betAmount)) return;
		
		//Check whether the user win
		boolean isWinner = bet.isLucky(game.getPrizeProbability());
 		
		//Update the balance
		betAmount = updateBalance(betAmount, isWinner);
		
		//Output log
		LOGGER.info("Transaction: " + UUID.randomUUID() + " Player: " + uuid + " Amount: " + betAmount + " Game: " + game.getName());
	}
	
	/**
	 * Add or Substract funds from the players credit 
	 * @param isWinner
	 */
	private int updateBalance(int betAmount, boolean isWinner) {
		if(!isWinner) {
			betAmount = -betAmount;
		}
		balance = balance.add(new BigDecimal(betAmount));
		return betAmount;
	}
	
	/**
	 * Check validations
	 * @return true if passed validations
	 */
	private boolean validBet(int betAmount) {
		//Check whether the bet is within the bounds
		if(betAmount < game.getBetMin() && betAmount > game.getBetMax()) {
			System.err.println(name + ": Incorrect bet: " + betAmount + " Please bet between " + game.getBetMin() + " and " + game.getBetMax());
			return false;
		}
		
		//Check whether the user has enough credit
		if(balance.compareTo(new BigDecimal(betAmount)) < 0) {
			System.err.println(name + ": Insufficient funds for bet " + betAmount + " Your current balance is " + formatBalance());
			return false;
		}
		return true;
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

package com.zitro.casino.core;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Contains the users bet logic
 * Runs asynchronously
 * 
 * @author insalada
 *
 */
@Component
@Scope("prototype")
public class PlayTask implements Runnable {

	private final Logger LOGGER = LogManager.getLogger(PlayTask.class);
	private Player player;
	private long startTime;
	@Autowired
	private Bet bet;
	@Autowired
	private Jackpot jackpot;

	
	public PlayTask(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		startTime = System.currentTimeMillis();
		while(hasCredit() && hasTime()){
			
			//User makes a bet
			BigDecimal betAmount = bet.randomBet(player.getGame().getConfig().getBetMin(), player.getGame().getConfig().getBetMax());

			//Pass validations
			if(!validBet(betAmount)) break;
			
			//Configured percentage goes to the Jackpot
			jackpot.addAmount(percentage(betAmount, jackpot.getPercentage()));
			
			//System.out.println(player.getName() + ", betAmount: " + formatAmount(betAmount) + " - jackpot: " + formatAmount(jackpot.getAmount()) + " " + formatTime(System.currentTimeMillis()));	
			
			//Check whether the user wins
			boolean isWinner = bet.isLucky(player.getGame().getPrizeProbability());
			
			//Play for the jackpot
			boolean isJackpot = bet.isLucky(jackpot.getProbability());

			//Update the balance
			betAmount = updateBalance(betAmount, isWinner, isJackpot);
			
			//Output log
			LOGGER.info("Transaction: " + UUID.randomUUID() + " Player: " + player.getName() + ", uuid: " + player.getUuid() + " Game: " + player.getGame().getName() + " Amount: " + formatAmount(betAmount) + " Current Balance: " + formatAmount(player.getBalance()));			
			
			//Player must wait till the next bet
			try {Thread.sleep(player.getWaitingTime()*1000);} catch (InterruptedException e) {}
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(player.getName() + " leaves the game after " + formatTime(totalTime));
	}

	/**
	 * Add or Substract funds from the players credit 
	 * @param isWinner
	 */
	private BigDecimal updateBalance(BigDecimal betAmount, boolean isWinner, boolean isJackpot) {
		if(isWinner) {
			if(isJackpot) {
				System.out.println(player.getName() + " " + player.getUuid() + ": WON THE JACKPOT!: " + jackpot.getAmount());
				BigDecimal newBalance = jackpot.win(player.getBalance());
				player.setBalance(newBalance);
				//player.setBalance(player.getBalance().add(jackpot.getAmount()));
				//jackpot.setAmount(BigDecimal.ZERO);//Reset the jackpot
			}
		}else{
			betAmount = betAmount.negate();
		}
		player.setBalance(player.getBalance().add(betAmount));
		return betAmount;
	}

	/**
	 * Check validations
	 * @return true if passed validations
	 */
	private boolean validBet(BigDecimal betAmount) {
		//Check whether the bet is within the bounds
		if(betAmount.compareTo(new BigDecimal(player.getGame().getConfig().getBetMin())) < 0 && betAmount.compareTo(new BigDecimal(player.getGame().getConfig().getBetMax())) > 0) {
			System.err.println(player.getName() + ": Incorrect bet: " + betAmount + " Please bet between " + player.getGame().getConfig().getBetMin() + " and " + player.getGame().getConfig().getBetMax());
			return false;
		}

		//Check whether the user has enough credit
		if(player.getBalance().compareTo(betAmount) < 0) {
			System.err.println(player.getName() + ": Insufficient funds for bet " + betAmount + " Your current balance is " + formatAmount(player.getBalance()));
			return false;
		}
		return true;
	}

	/**
	 * Format a BigDecimal amount in a more readable way
	 * @param amount
	 * @return String formatted
	 */
	private String formatAmount(BigDecimal amount) {
		return amount.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * Checks whether the player has still some credit
	 * @return true or false
	 */
	private boolean hasCredit() {
		BigDecimal minBet = new BigDecimal(player.getGame().getConfig().getBetMin());
		return player.getBalance().compareTo(minBet) >= 0;
	}

	/**
	 * Checks whether the player has still time to play
	 * @return true or false
	 */
	private boolean hasTime() {
		long currentTime = System.currentTimeMillis();
		long spentTime = currentTime - startTime;
		return player.getPlayingTime()*1000 > spentTime;
	}

	/**
	 * Provides a more readable format time
	 * @return String with ms formatted
	 */
	private String formatTime(long ms) {
		return String.format("%d min %d sec", 
				TimeUnit.MILLISECONDS.toMinutes(ms),
				TimeUnit.MILLISECONDS.toSeconds(ms) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms))
				);
	}
	
	/**
	 * Returns the given amount percentage
	 * @param amount
	 * @param percentage
	 * @return BigDecimal
	 */
	private BigDecimal percentage(BigDecimal amount, int percentage){
	    return amount.multiply(new BigDecimal(percentage)).divide(new BigDecimal(100));
	}

}

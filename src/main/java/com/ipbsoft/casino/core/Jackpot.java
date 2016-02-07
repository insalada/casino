package com.ipbsoft.casino.core;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * Singleton to manage the Jackpot
 * 
 * @author insalada
 *
 */
@Component
public class Jackpot {
	
	@Value("${jackpot.percentage}")
	private int percentage;
	
	@Value("${jackpot.probability}")
	private int probability;
	
	private BigDecimal amount;
	
	public Jackpot() {
		this.amount = BigDecimal.ZERO;
	}
	
	
	public synchronized BigDecimal getAmount() {
		return amount;
	}

	public synchronized void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	/**
	 * Accumulate the amount for the jackpot
	 * @param bet
	 */
	public synchronized void addAmount(BigDecimal bet) {
		amount = amount.add(bet);
	}
	
	/**
	 * Reset the jackpot and return the new balance
	 * @param balance
	 * @return
	 */
	public synchronized BigDecimal win(BigDecimal balance) {
		balance = balance.add(amount);
		amount = BigDecimal.ZERO;
		return balance;
	}
	
	public int getPercentage() {
		return percentage;
	}
	
	public int getProbability() {
		return probability;
	}
}

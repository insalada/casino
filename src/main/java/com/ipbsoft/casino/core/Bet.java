package com.ipbsoft.casino.core;


import java.math.BigDecimal;
import java.util.Random;
import org.springframework.stereotype.Component;

/**
 * Provides methods for the players bet 
 * 
 * @author insalada
 *
 */
@Component
public class Bet {

	private Random rnd = new Random();

	/**
	 * Returns a random value within a range cast to BigDecimal
	 * 
	 * @param min
	 * @param max
	 * @return BigDecimal with the random value
	 */
	public BigDecimal randomBet(int min, int max) {
		return new BigDecimal(rnd.nextInt((max - min) + 1) + min);
	}
		
	/**
	 * Calculates whether the user win or loose based on the given probability
	 * 
	 * @param probability
	 * @return true when win, false otherwise
	 */
	public boolean isLucky(int probability){
		if(probability >= 100) {
			return true;
		}else{
			Random ran = new Random();
			int random = ran.nextInt(100);
			if(random<probability) return true;
		}
		return false;
	}
}

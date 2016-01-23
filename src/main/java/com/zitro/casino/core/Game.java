package com.zitro.casino.core;

/**
 * Interface specifically for a Game behaviour
 * 
 * @author insalada
 *
 */
public interface Game {
	/**
	 * Gets the name of the game
	 */
	String getName();
	
	/**
	 * Gets the chances to win the prize
	 */
	int getPrizeProbability();
	
	/**
	 * Gets the minimun bet amount 
	 */
	int getBetMin();
	
	/**
	 * Gets the maximal bet amount
	 */
	int getBetMax();
}

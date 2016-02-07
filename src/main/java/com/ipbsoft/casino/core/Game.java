package com.ipbsoft.casino.core;

/**
 * Interface for a Game behaviour
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
	 * Gets the game config
	 */
	Config getConfig();
}

package com.zitro.casino.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.zitro.casino.factory.PlayTaskFactory;

/**
 * 
 * @author insalada
 *
 */
@SuppressWarnings("serial")
public class CasinoPoolManager extends ThreadPoolTaskExecutor {
	
	@Autowired
	PlayTaskFactory taskFactory;
	
	public CasinoPoolManager() {
		super();
	}
	
	
	/**
	 * 
	 * @param player
	 * @param game
	 */
	public void dispatchPlayer(Player player, Game game, Config config) {
		//Sit a player in the choosen game
		player.setGame(game);
		
		//Set game settings
		
		
		//Instance a background task based on the player values
		PlayTask task = taskFactory.create(player);		
		
		//Dispatch
		super.execute(task);
	}

}

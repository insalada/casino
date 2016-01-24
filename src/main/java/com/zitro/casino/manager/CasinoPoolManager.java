package com.zitro.casino.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.zitro.casino.core.Game;
import com.zitro.casino.core.Player;
import com.zitro.casino.factory.PlayTaskFactory;
import com.zitro.casino.task.PlayTask;

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
	public void dispatchPlayer(Player player, Game game) {
		//Sit a player in the choosen game
		player.setGame(game);
		
		//Instance a background task based on the player values
		PlayTask task = taskFactory.create(player);		
		
		//Dispatch
		super.execute(task);
	}

}

package com.zitro.casino;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SuppressWarnings("serial")
public class CasinoPoolManager extends ThreadPoolTaskExecutor {
	
	public CasinoPoolManager() {
		super();
	}
	
	public void dispatchPlayer(Player player) {
		//Instance a background task based on the player values
		PlayTask task = new PlayTask(player);
		
		//Dispatch
		super.execute(task);
	}

}

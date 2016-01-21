package com.zitro.casino;

import java.math.BigDecimal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PlayTask implements Runnable {

	private Player player;
	private long startTime;

	public PlayTask(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
				
		startTime = System.currentTimeMillis();
		

		
		while(hasCredit() && hasTime()){
			//System.out.println("Player is now playing: " + player.getName() + " - " + player.getWaitingTime());
			player.bet();
			
			//Player must wait for the next turn
			try {
				Thread.sleep(player.getWaitingTime());
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println(player.getName() + " is leaving the game. Time over");
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
	}
	
	/**
	 * Checks whether the player has still some credit
	 * @return true or false
	 */
	private boolean hasCredit() {
		return player.getBalance().compareTo(BigDecimal.ZERO) > 0;
	}
	
	/**
	 * Checks whether the player has still time to play
	 * @return true or false
	 */
	private boolean hasTime() {
		long currentTime = System.currentTimeMillis();
		long spentTime = currentTime - startTime;
		return player.getPlayingTime() > spentTime;
	}

}

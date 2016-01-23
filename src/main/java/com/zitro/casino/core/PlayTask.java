package com.zitro.casino.core;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author insalada
 *
 */
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
			player.play();
			
			//Player must wait for the next turn
			try {
				Thread.sleep(player.getWaitingTime());
			} catch (InterruptedException e) {
			}
		}
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Time over: " + player.getName() + " leaves the game after " + formatTime(totalTime));
		
	}
	
	/**
	 * Checks whether the player has still some credit
	 * @return true or false
	 */
	private boolean hasCredit() {
		BigDecimal minBet = new BigDecimal(player.getGame().getBetMin());
		System.out.println("current balance is " + player.getBalance() + " and the min bet is " + minBet + " so the user hasCredit? " + (player.getBalance().compareTo(minBet) >= 0));
		return player.getBalance().compareTo(minBet) >= 0;
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
	
	/**
	 * Provides a more readable format time
	 * @return String with ms formatted
	 */
	public String formatTime(long ms) {
		return String.format("%d min %d sec", 
		    TimeUnit.MILLISECONDS.toMinutes(ms),
		    TimeUnit.MILLISECONDS.toSeconds(ms) - 
		    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms))
	    );
	}

}

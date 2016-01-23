package com.zitro.casino.core;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Bet {

	private Random rnd = new Random();
	
	public Bet(){
		System.out.println("bet constructor");
	}

	public int randomBet(int min, int max) {
		return rnd.nextInt((max - min) + 1) + min;
	}
	
	public double randomBetDecimal(int min, int max) {
		return min + (max - min) * rnd.nextDouble();
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

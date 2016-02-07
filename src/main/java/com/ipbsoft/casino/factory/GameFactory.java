package com.ipbsoft.casino.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ipbsoft.casino.core.Config;
import com.ipbsoft.casino.core.Game;
import com.ipbsoft.casino.impl.Bingo;
import com.ipbsoft.casino.impl.Blackjack;
import com.ipbsoft.casino.impl.Poker;
import com.ipbsoft.casino.impl.Ruleta;
import com.ipbsoft.casino.impl.Slot;

/**
 * Implementation of the Factory Pattern for creating the different Game instances
 * 
 * @author insalada
 *
 */

public class GameFactory {

	@Autowired
	private ApplicationContext context;
	
	/**
	 * Returns an instance of type Game based on the game name with the provided settings
	 * 
	 * @param game
	 * @param config
	 * @return an instance of type Game
	 */
	@Bean
	public Game create(String game, Config config) {
		if(game == "VIDEOBINGO") {
			Bingo bingo = new Bingo(config);
			context.getAutowireCapableBeanFactory().autowireBean(bingo);
			return bingo;
		}else if(game == "SLOT") {
			Slot slot = new Slot(config);
			context.getAutowireCapableBeanFactory().autowireBean(slot);
			return slot;
		}else if(game == "BLACKJACK") {
			Blackjack blackjack = new Blackjack(config);
			context.getAutowireCapableBeanFactory().autowireBean(blackjack);
			return blackjack;
		}else if(game == "POKER") {
			Poker poker = new Poker(config);
			context.getAutowireCapableBeanFactory().autowireBean(poker);
			return poker;
		}else if(game == "RULETA") {
			Ruleta ruleta = new Ruleta(config);
			context.getAutowireCapableBeanFactory().autowireBean(ruleta);
			return ruleta;
		}
		return null;
	}
	

}

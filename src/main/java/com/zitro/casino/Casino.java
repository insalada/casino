package com.zitro.casino;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zitro.casino.config.AppConfig;
import com.zitro.casino.core.Config;
import com.zitro.casino.core.Game;
import com.zitro.casino.core.Player;
import com.zitro.casino.core.Provider;
import com.zitro.casino.factory.ConfigFactory;
import com.zitro.casino.factory.GameFactory;
import com.zitro.casino.factory.PlayerFactory;
import com.zitro.casino.manager.CasinoPoolManager;

/**
 * 
 * Casino Main Class: 
 * 
 * - Loads the context
 * - Initialize objects
 * - Dispatch the tasks
 * - Close the context
 * 
 * @author insalada
 *
 */
public class Casino {
	
	public static void main(String[] args) {
		
		//Say Hello
		System.out.println("Welcome to Zitro Casino");
		
		//Loading Spring context
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
				
		//Initialize Providers
		Provider bet365 = new Provider("Bet356");
		Provider bwin = new Provider("Bwin");
		Provider pokerstar = new Provider("PokerStar");
		Provider marca = new Provider("Marca Apuestas");
		
		//Generate Players
		PlayerFactory playerFactory = (PlayerFactory) context.getBean("playerFactory");
		Player ivan = playerFactory.generate("Ivan", "500", 20, 4, bet365);
		Player pepe = playerFactory.generate("Pepe", "300", 25, 6, bwin);
		Player noelia = playerFactory.generate("Noelia", "1000", 50, 5, marca);
		Player elsa = playerFactory.generate("Elsa", "800", 45, 8, pokerstar);
		Player javier = playerFactory.generate("Javier", "400", 40, 2, bwin);
		
		//Players choose their settings
		Config configIvan = ConfigFactory.create(10, 50);
		Config configPepe = ConfigFactory.create(30, 60);
		Config configNoelia = ConfigFactory.create(10, 100);
		Config configElsa = ConfigFactory.create(20, 80);
		Config configJavier = ConfigFactory.create(10, 80);
		
		//Generate Games
		GameFactory gameFactory = (GameFactory) context.getBean("gameFactory");
		Game bingoIvan = gameFactory.create("VIDEOBINGO", configIvan);
		Game slotPepe = gameFactory.create("SLOT", configPepe);
		Game blackjackNoe = gameFactory.create("BLACKJACK", configNoelia);		
		Game pokerElsa = gameFactory.create("POKER", configElsa);
		Game ruletaJavier = gameFactory.create("RULETA", configJavier);
		
	    //Dispatch Players
	    CasinoPoolManager manager = (CasinoPoolManager) context.getBean("manager");
	    manager.dispatchPlayer(ivan, bingoIvan);
	    manager.dispatchPlayer(pepe, slotPepe);
	    manager.dispatchPlayer(noelia, blackjackNoe);
	    manager.dispatchPlayer(elsa, pokerElsa);
	    manager.dispatchPlayer(javier, ruletaJavier);
	    
	    //Free Spring context
	    ((ConfigurableApplicationContext)context).close();
	}
	
}

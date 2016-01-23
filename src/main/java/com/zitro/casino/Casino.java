package com.zitro.casino;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zitro.casino.config.AppConfig;
import com.zitro.casino.core.CasinoPoolManager;
import com.zitro.casino.core.Game;
import com.zitro.casino.core.Player;
import com.zitro.casino.core.PlayerFactory;
import com.zitro.casino.impl.Bingo;
import com.zitro.casino.impl.Ruleta;


public class Casino {
	
	
	public static void main(String[] args) {
		
		//Say Hello
		System.out.println("Welcome to Zitro Casino");

		
		//Loading Spring context
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
				
		//Generate Games
		Game bingo = (Bingo) context.getBean("bingo");
		Game ruleta = (Ruleta) context.getBean("ruleta");
		
		//Generate Players
		PlayerFactory factory = (PlayerFactory) context.getBean("factory");
		Player ivan = factory.generate("ivan", new BigDecimal("200"), 10000, 1000, "Bet356");
		Player pepe = factory.generate("pepe", new BigDecimal("300"), 20000, 5000, "Marca Apuestas");
		
		//Users sit on a choosen game
		//TODO: randomize
		ivan.setGame(bingo);
		pepe.setGame(ruleta);	   	

		
	    //Dispatch Players
	    CasinoPoolManager manager = (CasinoPoolManager) context.getBean("manager");
	    manager.dispatchPlayer(ivan);
	    //manager.dispatchPlayer(pepe);
	    
	    
	    
	    //Free Spring context
	    ((ConfigurableApplicationContext)context).close();
	}
	

	

}

package com.zitro.casino;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zitro.casino.config.AppConfig;
import com.zitro.casino.core.CasinoPoolManager;
import com.zitro.casino.core.Game;
import com.zitro.casino.impl.Bingo;


public class Casino {

	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to Zitro Casino");
		
		//Loading Spring context
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		//Generate Games
		Game bingo = (Bingo) context.getBean("bingo");
		
		
		//Generate Player
	    Player ivan = new Player("ivan", new BigDecimal("100"), 10000, 1000, "Bet356", bingo);
	    //Player pepe = new Player("pepe", new BigDecimal("500"), 20000, 5000, "Marca Apuestas", ruleta);
	   	    
	    //Dispatch Players
	    CasinoPoolManager manager = (CasinoPoolManager) context.getBean("manager");
	    manager.dispatchPlayer(ivan);
	    //manager.dispatchPlayer(pepe);
	    
	    
	    
	    //Free Spring context
	    ((ConfigurableApplicationContext)context).close();
	}
	

	

}

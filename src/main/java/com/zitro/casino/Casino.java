package com.zitro.casino;

import java.math.BigDecimal;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.zitro.casino.config.AppConfig;


public class Casino {


	public static void main(String[] args) {
		
		System.out.println("Welcome to Zitro Casino");
		
		//Loading Spring context
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//Player p = (Player) context.getBean("player");
	    //p.play();
		
		ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");
		ThreadPoolTaskScheduler scheduler = (ThreadPoolTaskScheduler) context.getBean("scheduler");
		CasinoPoolManager manager = (CasinoPoolManager) context.getBean("manager");
		
	    Player ivan = new Player("ivan", new BigDecimal("100"), 10000, 1000, "Bet356");
	    Player pepe = new Player("pepe", new BigDecimal("500"), 20000, 5000, "Marca Apuestas");
	    
	    //PlayTask taskIvan = new PlayTask(ivan);
	    //PlayTask taskPepe = new PlayTask(pepe);
	    
	    //taskExecutor.execute(taskIvan);
	    //taskExecutor.execute(taskPepe);
	    
	    
	    
	    
	    
	    
	    
	    manager.dispatchPlayer(ivan);
	    manager.dispatchPlayer(pepe);
	    
	    
	    
	    
	    //Free Spring context
	    ((ConfigurableApplicationContext)context).close();
	}
	

}

package com.zitro.casino.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.zitro.casino.core.PlayTask;
import com.zitro.casino.core.Player;

/**
 * Factory creator for the tasks
 * @author insalada
 *
 */
public class PlayTaskFactory {

	@Autowired
	private ApplicationContext context;

	/**
	 * Returns a bean based on the given parameters and wire to the context
	 * @param player
	 * @return
	 */
	@Bean
	public PlayTask create(Player player) {
		//Create the bean based on given parameters
		PlayTask task = new PlayTask(player);
		//Let's add the autowire capacity to the bean
		context.getAutowireCapableBeanFactory().autowireBean(task);
		return task;
	}
	
}
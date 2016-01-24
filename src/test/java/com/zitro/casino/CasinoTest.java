package com.zitro.casino;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.zitro.casino.config.AppConfig;
import com.zitro.casino.core.CasinoPoolManager;
import com.zitro.casino.core.Config;
import com.zitro.casino.core.Game;
import com.zitro.casino.core.Player;
import com.zitro.casino.core.Provider;
import com.zitro.casino.factory.ConfigFactory;
import com.zitro.casino.factory.GameFactory;
import com.zitro.casino.factory.PlayerFactory;


/**
 * Tests for the 
 * @author insalada
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class CasinoTest {
	
	@Autowired
	private ApplicationContext context;
	@Autowired
	private PlayerFactory playerFactory;
	@Autowired
	private GameFactory gameFactory;
	@Autowired
	private CasinoPoolManager manager;
	
	private Provider mockProvider;
	private Player mockPlayer;
	private Config mockConfig;
	
	private String test = null;
	
	
	@Before
    public void init() {
		mockProvider = new Provider("Bwin");
		mockPlayer = playerFactory.generate("Mock", "500", 20, 4, mockProvider);
		mockConfig = ConfigFactory.create(10, 50);
		
    }
	
	@Test
	public void testMain() {
		
		Game bingo = gameFactory.create("VIDEOBINGO", mockConfig);
		manager.dispatchPlayer(mockPlayer, bingo, mockConfig);
		//assertTrue(test==null);
	}
	
	public void should_never_change_quailty_of_Millenary_Honey() throws Exception {
		
	}
	
}

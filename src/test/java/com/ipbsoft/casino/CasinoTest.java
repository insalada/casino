package com.ipbsoft.casino;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ipbsoft.casino.config.AppConfig;
import com.ipbsoft.casino.core.Bet;
import com.ipbsoft.casino.core.Config;
import com.ipbsoft.casino.core.Game;
import com.ipbsoft.casino.core.Jackpot;
import com.ipbsoft.casino.factory.ConfigFactory;
import com.ipbsoft.casino.factory.GameFactory;
import com.ipbsoft.casino.impl.Bingo;


/**
 * Some Tests for the casino
 * @author insalada
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class CasinoTest {
	
	@Autowired
	private GameFactory gameFactory;
	@Autowired
	private Bet bet;
	@Autowired
	private Jackpot jackpot;
	private Config mockConfig;
	private Game mockGame;
	
	
	@Before
    public void init() {
		mockConfig = ConfigFactory.create(10, 50);
		mockGame = gameFactory.create("VIDEOBINGO", mockConfig);
    }
	
	
	@Test
	public void should_factory_game_return_proper_instanceof() {
		assertTrue(mockGame instanceof Bingo);
	}
	
	
	@Test
	public void should_the_game_have_setted_config() throws Exception {
		assertEquals(mockConfig, mockGame.getConfig());
	}
	
	@Test
	public void should_random_bet_return_a_number_within_range() {
		BigDecimal randomBd = bet.randomBet(10, 20);
		BigDecimal mockMin = new BigDecimal("10");
		BigDecimal mockMax = new BigDecimal("20");
		assertTrue(randomBd.compareTo(mockMin) >= 0 && randomBd.compareTo(mockMax) <= 0);
	}
	
	@Test
	public void should_isLucky_return_true_when_100_probabilities() {
		assertTrue(bet.isLucky(100));
	}
	
	@Test
	public void should_isLucky_return_false_when_0_probabilities() {
		assertFalse(bet.isLucky(0));
	}

	
	@Test
	public void should_jackpot_been_reset_when_somebody_wins() {
		BigDecimal mockAmount = new BigDecimal("100");
		jackpot.setAmount(mockAmount);
		jackpot.win(mockAmount);
		assertTrue(jackpot.getAmount().compareTo(BigDecimal.ZERO) == 0);
	}
	
	@Test
	public void should_jackpot_return_the_added_balance_when_somebody_wins() {
		jackpot.setAmount(BigDecimal.ZERO);
		BigDecimal mockAmount = new BigDecimal("50");
		BigDecimal balance = jackpot.win(mockAmount);
		assertEquals(mockAmount, balance);
	}
	
	@Test
	public void should_properties_file_been_loaded() throws Exception {
		assertNotNull(mockGame.getName());
	}
	
}

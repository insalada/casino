package com.zitro.casino.core;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * 
 * @author insalada
 *
 */
@Scope("prototype")
public class Transaction {
	private UUID uuid;
	private BigDecimal amount;
	private Player player;
	
	public Transaction(BigDecimal amount, Player player) {
		this.uuid = UUID.randomUUID();
		this.amount = amount;
		this.player = player;
	}
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

}

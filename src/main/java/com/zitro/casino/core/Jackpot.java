package com.zitro.casino.core;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Jackpot {
	
	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}

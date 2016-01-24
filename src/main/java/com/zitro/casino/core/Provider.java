package com.zitro.casino.core;

import java.util.UUID;

/**
 * Represent each users provider
 * @author insalada
 *
 */
public class Provider {

	private String name;
	private UUID uuid;
	
	public Provider (String name) {
		this.name = name;
		this.uuid = UUID.randomUUID();
	}

	public String getName() {
		return name;
	}

	public UUID getUuid() {
		return uuid;
	}
}

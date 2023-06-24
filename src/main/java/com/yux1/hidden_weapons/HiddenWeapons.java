package com.yux1.hidden_weapons;

import com.yux1.hidden_weapons.block.ModBlocks;
import com.yux1.hidden_weapons.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiddenWeapons implements ModInitializer {

	public static final String MOD_ID = "hidden_weapons";

	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("This is Hidden Weapons Saying!!!");
	}
}

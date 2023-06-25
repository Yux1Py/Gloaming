package com.yux1.gloaming;

import com.yux1.gloaming.block.ModBlocks;
import com.yux1.gloaming.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gloaming implements ModInitializer {

	public static final String MOD_ID = "gloaming";

	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("This is Hidden Weapons Saying!!!");
	}
}

package com.yux1.gloaming.item;

import com.yux1.gloaming.Gloaming;

import com.yux1.gloaming.item.custom.DaggerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item WOODEN_DAGGER = registerItem("wooden_dagger",
            getDaggerItem(ToolMaterials.WOOD));

    public static final Item STONE_DAGGER = registerItem("stone_dagger",
            getDaggerItem(ToolMaterials.STONE));

    public static final Item COPPER_DAGGER = registerItem("copper_dagger",
            getDaggerItem(ModToolMaterials.COPPER));

    public static final Item IRON_DAGGER = registerItem("iron_dagger",
            getDaggerItem(ToolMaterials.IRON));

    public static final Item GOLDEN_DAGGER = registerItem("golden_dagger",
            getDaggerItem(ToolMaterials.GOLD));

    public static final Item DIAMOND_DAGGER = registerItem("diamond_dagger",
            getDaggerItem(ToolMaterials.DIAMOND));

    public static final Item NETHERITE_DAGGER = registerItem("netherite_dagger",
            getDaggerItem(ToolMaterials.NETHERITE));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Gloaming.MOD_ID, name), item);
    }

    private static DaggerItem getDaggerItem(ToolMaterial toolMaterial){
        return new DaggerItem(toolMaterial, 2, -0.5f,
                new FabricItemSettings().group(ModItemGroup.GLOAMING));
    }

    public static void registerModItems(){
        Gloaming.LOGGER.info("Registering Mod Items for " + Gloaming.MOD_ID);
    }
}

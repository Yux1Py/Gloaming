package com.yux1.gloaming.item;

import com.yux1.gloaming.Gloaming;

import com.yux1.gloaming.item.custom.DaggerItem;
import com.yux1.gloaming.item.custom.KnuckleDustersItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //匕首们
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

    //指虎们
    public static final Item COPPER_KNUCKLE_DUSTERS = registerItem("copper_knuckle_dusters",
            getKnuckleDustersItem(ModToolMaterials.COPPER));

    public static final Item IRON_KNUCKLE_DUSTERS = registerItem("iron_knuckle_dusters",
            getKnuckleDustersItem(ToolMaterials.IRON));

    public static final Item GOLDEN_KNUCKLE_DUSTERS = registerItem("golden_knuckle_dusters",
            getKnuckleDustersItem(ToolMaterials.GOLD));

    public static final Item DIAMOND_KNUCKLE_DUSTERS = registerItem("diamond_knuckle_dusters",
            getKnuckleDustersItem(ToolMaterials.DIAMOND));

    public static final Item NETHERITE_KNUCKLE_DUSTERS = registerItem("netherite_knuckle_dusters",
            getKnuckleDustersItem(ToolMaterials.NETHERITE));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Gloaming.MOD_ID, name), item);
    }

    private static DaggerItem getDaggerItem(ToolMaterial toolMaterial){
        return new DaggerItem(toolMaterial, 2, -0.5f,
                new FabricItemSettings().group(ModItemGroup.GLOAMING));
    }

    private static KnuckleDustersItem getKnuckleDustersItem(ToolMaterial toolMaterial){
        return new KnuckleDustersItem(toolMaterial, 1, 0.5f,
                new FabricItemSettings().group(ModItemGroup.GLOAMING));
    }


    public static void registerModItems(){
        Gloaming.LOGGER.info("Registering Mod Items for " + Gloaming.MOD_ID);
    }
}

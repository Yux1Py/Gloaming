package com.yux1.hidden_weapons.item;

import com.yux1.hidden_weapons.HiddenWeapons;

import net.minecraft.item.Item;
import net.minecraft.item.StewItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {



    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(HiddenWeapons.MOD_ID, name), item);
    }

    public static void registerModItems(){
        HiddenWeapons.LOGGER.info("Registering Mod Items for " + HiddenWeapons.MOD_ID);
    }
}

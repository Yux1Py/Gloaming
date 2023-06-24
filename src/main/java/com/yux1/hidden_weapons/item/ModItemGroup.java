package com.yux1.hidden_weapons.item;

import com.yux1.hidden_weapons.HiddenWeapons;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup MENDELISM = FabricItemGroupBuilder.build(new Identifier(HiddenWeapons.MOD_ID, "hidden_weapons"),
            () -> new ItemStack(Items.DIAMOND));
}

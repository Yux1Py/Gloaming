package com.yux1.gloaming.enchantment;

import com.yux1.gloaming.Gloaming;
import com.yux1.gloaming.enchantment.custom.LurkEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModEnchantment {

    public static final Enchantment LURK = registerEnchantment("lurk",
            new LurkEnchantment(Enchantment.Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    public static void registerModEnchantments(){
        System.out.println("Registering Enchantments for " + Gloaming.MOD_ID);
    }

    private static Enchantment registerEnchantment(String name, Enchantment enchantment){
        return Registry.register(Registry.ENCHANTMENT, new Identifier(Gloaming.MOD_ID, name), enchantment);
    }

}

package com.yux1.gloaming.util;

import com.yux1.gloaming.item.custom.DaggerItem;
import com.yux1.gloaming.item.custom.KnuckleDustersItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModUtils {

    public static boolean hasPlayerModItemStackInInventory(PlayerEntity player){
        for (int i = 0; i < player.getInventory().size(); i ++){
            ItemStack currentStack = player.getInventory().getStack(i);
            if (!currentStack.isEmpty()){
                if (currentStack.getItem() instanceof DaggerItem)
                {
                    return true;
                }
                if (currentStack.getItem() instanceof KnuckleDustersItem)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static ItemStack getModItemInInventory(PlayerEntity player){
        for (int i = 0; i < player.getInventory().size(); i ++){
            ItemStack currentStack = player.getInventory().getStack(i);
            if (!currentStack.isEmpty()){
                if (currentStack.getItem() instanceof DaggerItem)
                {
                    return currentStack;
                }
                if (currentStack.getItem() instanceof KnuckleDustersItem)
                {
                    return currentStack;
                }
            }
        }
        return null;
    }

    public static int getModItemIndexInInventory(PlayerEntity player){
        for (int i = 0; i < player.getInventory().size(); i ++){
            ItemStack currentStack = player.getInventory().getStack(i);
            if (!currentStack.isEmpty()){
                if (currentStack.getItem() instanceof DaggerItem)
                {
                    return i;
                }
                if (currentStack.getItem() instanceof KnuckleDustersItem)
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean hasPlayerStackInInventory(PlayerEntity player, Item item){
        for (int i = 0; i < player.getInventory().size(); i ++){

            ItemStack currentStack = player.getInventory().getStack(i);

            if (!currentStack.isEmpty() && currentStack.isItemEqual(new ItemStack(item))){
                return true;
            }
        }

        return false;
    }

    public static int getFirstInventoryIndex(PlayerEntity player, Item item){
        for (int i = 0; i < player.getInventory().size(); i ++){

            ItemStack currentStack = player.getInventory().getStack(i);

            if (!currentStack.isEmpty() && currentStack.isItemEqual(new ItemStack(item))){
                return i;
            }
        }

        return -1;
    }
}

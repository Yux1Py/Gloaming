package com.yux1.gloaming;

import com.yux1.gloaming.util.ModUtils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class GloamingClient implements ClientModInitializer {

    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.gloaming.operate", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_G, // The keycode of the key
                "category.gloaming.key" // The translation key of the keybinding's category.
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                if (client.player != null && client.player.getMainHandStack() == ItemStack.EMPTY) {
                    client.player.sendMessage(new LiteralText("啊？"), false);
                    if (ModUtils.hasPlayerModItemStackInInventory(client.player)) {
                        ItemStack stack = ModUtils.getModItemInInventory(client.player);
                        int index = client.player.getInventory().selectedSlot;
                        client.player.getInventory().insertStack(index, stack);
                        //client.player.sendMessage(new LiteralText(String.valueOf(EquipmentSlot.MAINHAND.getEntitySlotId())), false);
                        client.player.sendMessage(new LiteralText("啊!"), false);
                    }
                }
            }
        });
    }
}

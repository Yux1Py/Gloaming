package com.yux1.gloaming.item.custom;

import com.yux1.gloaming.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;

import java.util.Random;

public class KnuckleDustersItem extends SwordItem {
    //指虎
    public KnuckleDustersItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        cooperateAttack(stack, target, attacker);
        return super.postHit(stack, target, attacker);
    }

    //实现左右手指虎的协同攻击
    private void cooperateAttack(ItemStack stack, LivingEntity target, LivingEntity attacker){
        //一个貌似没用的判断
        if (stack.getItem() instanceof KnuckleDustersItem){
            //转玩家并获取左手物品
            PlayerEntity player = (PlayerEntity) attacker;
            ItemStack leftHandStack = player.getStackInHand(Hand.OFF_HAND);
            //左手物品是否也为指虎
            if (leftHandStack.getItem() instanceof KnuckleDustersItem){
                //造成协同伤害
                float leftHandStackAttackDamage = 1.0f;
                //赋值
                if (leftHandStack.getItem() == ModItems.COPPER_KNUCKLE_DUSTERS){
                    leftHandStackAttackDamage += 3.5f;
                }
                else if (leftHandStack.getItem() == ModItems.IRON_KNUCKLE_DUSTERS){
                    leftHandStackAttackDamage += 4.0f;
                }
                else if (leftHandStack.getItem() == ModItems.GOLDEN_KNUCKLE_DUSTERS){
                    leftHandStackAttackDamage += 2.0f;
                }
                else if (leftHandStack.getItem() == ModItems.DIAMOND_KNUCKLE_DUSTERS){
                    leftHandStackAttackDamage += 5.0f;
                }
                else if (leftHandStack.getItem() == ModItems.NETHERITE_KNUCKLE_DUSTERS){
                    leftHandStackAttackDamage += 6.0f;
                }

                target.damage(DamageSource.mob(attacker), leftHandStackAttackDamage);
                if (!player.isCreative()){
                    player.getStackInHand(Hand.OFF_HAND).damage(1, new Random(), (ServerPlayerEntity) player);
                }

                player.sendMessage(new LiteralText(String.valueOf(leftHandStackAttackDamage)), false);
                player.swingHand(Hand.OFF_HAND);
            }
        }
    }


}

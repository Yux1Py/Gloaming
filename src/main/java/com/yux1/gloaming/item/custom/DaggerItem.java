package com.yux1.gloaming.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtList;
import net.minecraft.text.LiteralText;

import java.util.Objects;

public class DaggerItem extends SwordItem {

    //匕首
    public DaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        causeLurkDamage(stack, target, attacker);

        return super.postHit(stack, target, attacker);
    }

    //造成潜伏状态伤害
    private void causeLurkDamage(ItemStack stack, LivingEntity target, LivingEntity attacker){
        //将攻击者转化为玩家对象
        PlayerEntity player = (PlayerEntity) attacker;

        //检测是否满足潜伏条件
        if (isSneak(attacker) || isBehindBack(target, attacker)) {
            //先定义好潜伏伤害值
            float lurkAttackDamage = this.getAttackDamage();

            //如果同时满足两种造成潜伏条件则升高潜伏伤害值
            if (isSneak(attacker) && isBehindBack(target, attacker)){
                lurkAttackDamage *= 1.5f;
            }

            //检测是否有潜伏附魔并以此升高潜伏伤害值
            NbtList nbt = stack.getEnchantments();
            for (int i = 0; i < nbt.size(); i++){
                if (Objects.equals(nbt.getCompound(i).getString("id"), "gloaming:lurk")){
                    int level = nbt.getCompound(i).getInt("lvl");
                    if (level == 1){
                        lurkAttackDamage *= 1.2f;
                    }
                    else if (level == 2){
                        lurkAttackDamage *= 1.4f;
                    }
                    else if (level == 3){
                        lurkAttackDamage *= 1.6f;
                    }
                    else if (level == 4){
                        lurkAttackDamage *= 1.8f;
                    }
                    else if (level == 5){
                        lurkAttackDamage *= 2.0f;
                    }
                }
            }
            target.damage(DamageSource.mob(attacker), lurkAttackDamage);
            player.sendMessage(new LiteralText(String.valueOf(lurkAttackDamage)), false);
        }
    }

    private boolean isSneak(LivingEntity attacker){
        PlayerEntity player = (PlayerEntity) attacker;
        //判断是否在潜行
        return player.isSneaking();
    }

    private boolean isBehindBack(LivingEntity target, LivingEntity attacker){
        //取目标与攻击者的角度与差
        float attackerYaw = attacker.headYaw;
        float targetYaw = target.bodyYaw;
        float difference = attackerYaw - targetYaw;

        //化为360内的数
        if (difference < -320){
            difference += 360;
        }
        else if (difference > 320){
            difference -= 360;
        }

        //取绝对值
        if (difference < 0){
            difference = -difference;
        }

        //判断是否在背后~~
        return difference < 30;
    }
}

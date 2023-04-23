package net.dixta.dixtas_armory.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.extensions.IForgePlayer;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class AdvancedAxeItem extends AxeItem {
    public static UUID weaponRangeUUID = UUID.fromString("3ecafd9f-e51f-4b8e-8af7-17d96339260f");
    public static UUID weaponKnockbackUUID = UUID.fromString("8948b3c6-81dc-4788-bbc7-dd45a6fc856d");
    public static UUID twoHandedTagUUID = UUID.fromString("0627f79d-d31b-4d18-b645-25952e483585");

    public double pAttackRange;
    boolean pIsTwoHanded;
    int pDigDamage;
    int pLevelTwoHanded;
    float pArmorPiercing;
    float pMineSpeedX;
    float pAttackSpeed;
    float pAttackKnockback;
    float pAttackDamage;
    float pCurrentAttackDamage;
    float pTwoHandedIDamage;
    float pTwoHandedIIDamage;
    float pTwoHandedISpeed;
    float pTwoHandedIISpeed;
    int pInvincibilityTime;
    double pCharge;
    double pLastCharge;
    float pArmorPierceChance;
    Random random = new Random();



    public AdvancedAxeItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties,double pAttackRangeModifier, float pArmorPiercingModifier, float pArmorPiercingChance,int pTwoHandedLevel, int pMinorlyReducedDamage, int pMajorlyReducedDamage, float pMinorlyReducedSpeed, float pMajorlyReducedSpeed, int pInvulnerabilityTime, int pDigDurability, float pMineSpeed) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);

        pAttackSpeed = pAttackSpeedModifier;
        pAttackDamage = pAttackDamageModifier + pTier.getAttackDamageBonus();
        pAttackRange = pAttackRangeModifier - 3;
        pIsTwoHanded = (pTwoHandedLevel > 0);
        pDigDamage = pDigDurability;
        pLevelTwoHanded = pTwoHandedLevel;
        pArmorPiercing = pArmorPiercingModifier;
        pMineSpeedX = pMineSpeed;

        pTwoHandedISpeed = (float)pAttackSpeed - pMinorlyReducedSpeed;
        pTwoHandedIISpeed = (float)pAttackSpeed - pMajorlyReducedSpeed;
        pTwoHandedIDamage = pAttackDamage - pMinorlyReducedDamage;
        pTwoHandedIIDamage = pAttackDamage - pMajorlyReducedDamage;
        pInvincibilityTime = pInvulnerabilityTime;
        pArmorPierceChance = pArmorPiercingChance;
    }




    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if(slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier",findDamage(stack), AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", findSpeed(stack), AttributeModifier.Operation.ADDITION));
            builder.put(ForgeMod.ATTACK_RANGE.get(), new AttributeModifier(weaponRangeUUID, "Tool modifier", pAttackRange, AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(weaponKnockbackUUID, "Knockback modifier", pAttackKnockback, AttributeModifier.Operation.ADDITION));
            return builder.build();

        }
        return super.getAttributeModifiers(slot, stack);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        //Detect Attack-Charge
        Player pPlayer = ((Player) pEntity);
        if(pPlayer.getMainHandItem() == pStack) {
            pLastCharge = pCharge;
            pCharge = pPlayer.getAttackStrengthScale(0.5F);
        }

        //Detect Two-Handed
        if(!(pLevelTwoHanded == 0))
            twoHanded((LivingEntity)pEntity, pStack);
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    float findDamage(ItemStack stack) {
        switch(stack.getTag().getInt("dixtas_armory.two_handed")) {
            case 1:
                return pTwoHandedIDamage;
            case 2:
                return pTwoHandedIIDamage;

            default:
                return pAttackDamage;
        }
    }

    float findSpeed(ItemStack stack) {
        switch(stack.getTag().getInt("dixtas_armory.two_handed")) {
            case 1:
                return pTwoHandedISpeed;
            case 2:
                return pTwoHandedIISpeed;

            default:
                return (float)pAttackSpeed;
        }
    }

    private void twoHanded(LivingEntity pPlayer, ItemStack pStack) {
        if(pIsTwoHanded)
        {
            pStack.getOrCreateTag().putInt("dixtas_armory.two_handed", -1);

            if (pPlayer.getMainHandItem() == pStack)
            {
                if (!pPlayer.getOffhandItem().getItem().equals(Items.AIR))
                {
                    if(pLevelTwoHanded == 2 || checkHeavy(pPlayer.getOffhandItem()))
                        pStack.getOrCreateTag().putInt("dixtas_armory.two_handed", 2);
                    else
                        pStack.getOrCreateTag().putInt("dixtas_armory.two_handed", 1);
                }
            }
            else if (pPlayer.getOffhandItem() == pStack)
            {
                if (!pPlayer.getMainHandItem().getItem().equals(Items.AIR))
                {
                    if(pLevelTwoHanded == 2 || checkHeavy(pPlayer.getMainHandItem()))
                        pStack.getOrCreateTag().putInt("dixtas_armory.two_handed", 2);
                    else
                        pStack.getOrCreateTag().putInt("dixtas_armory.two_handed", 1);
                }
            }
        }
    }

    boolean checkHeavy(ItemStack pStack) {
        try {
            pStack.getTag().getInt("dixtas_armory.two_handed");
            return true;
        }
        catch(Exception error) {
            return false;
        }
    }

    float getDamageAfterMagicAbsorb(DamageSource pDamageSource, float pDamageAmount, LivingEntity pLiving ) {
        if (pDamageSource.isBypassMagic()) {
            return pDamageAmount;
        } else {
            if (pLiving.hasEffect(MobEffects.DAMAGE_RESISTANCE) && pDamageSource != DamageSource.OUT_OF_WORLD) {
                int i = (pLiving.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() + 1) * 5;
                int j = 25 - i;
                float f = pDamageAmount * (float)j;
                float f1 = pDamageAmount;
                pDamageAmount = Math.max(f / 25.0F, 0.0F);
                float f2 = f1 - pDamageAmount;
                if (f2 > 0.0F && f2 < 3.4028235E37F) {
                    if (pLiving instanceof ServerPlayer) {
                        ((ServerPlayer)pLiving).awardStat(Stats.CUSTOM.get(Stats.DAMAGE_RESISTED), Math.round(f2 * 10.0F));
                    } else if (pDamageSource.getEntity() instanceof ServerPlayer) {
                        ((ServerPlayer)pDamageSource.getEntity()).awardStat(Stats.CUSTOM.get(Stats.DAMAGE_DEALT_RESISTED), Math.round(f2 * 10.0F));
                    }
                }
            }

            if (pDamageAmount <= 0.0F) {
                return 0.0F;
            } else {
                int k = EnchantmentHelper.getDamageProtection(pLiving.getArmorSlots(), pDamageSource);
                if (k > 0) {
                    pDamageAmount = CombatRules.getDamageAfterMagicAbsorb(pDamageAmount, (float)k);
                }

                return pDamageAmount;
            }
        }
    }

    void actuallyHurt(DamageSource pDamageSource, float pDamageAmount, LivingEntity pTarget, LivingEntity pTest) {
        if (!pTarget.isInvulnerableTo(pDamageSource)) {
            pDamageAmount = net.minecraftforge.common.ForgeHooks.onLivingHurt(pTarget, pDamageSource, pDamageAmount);
            if (pDamageAmount <= 0) return;
            pDamageAmount = getDamageAfterMagicAbsorb(pDamageSource, pDamageAmount, pTarget);
            float f2 = Math.max(pDamageAmount - pTarget.getAbsorptionAmount(), 0.0F);
            pTarget.setAbsorptionAmount(pTarget.getAbsorptionAmount() - (pDamageAmount - f2));
            float f = pDamageAmount - f2;
            if (f > 0.0F && f < 3.4028235E37F && pDamageSource.getEntity() instanceof ServerPlayer) {
                ((ServerPlayer)pDamageSource.getEntity()).awardStat(Stats.CUSTOM.get(Stats.DAMAGE_DEALT_ABSORBED), Math.round(f * 10.0F));
            }

            f2 = net.minecraftforge.common.ForgeHooks.onLivingDamage(pTarget, pDamageSource, f2);
            if (f2 != 0.0F) {
                float f1 = pTarget.getHealth();
                pTarget.getCombatTracker().recordDamage(pDamageSource, f1, f2);
                pTarget.setHealth(f1 - f2); // Forge: moved to fix MC-121048
                pTarget.setAbsorptionAmount(pTarget.getAbsorptionAmount() - f2);
                pTarget.gameEvent(GameEvent.ENTITY_DAMAGED, pDamageSource.getEntity());
            }
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(pDigDamage, pAttacker, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });

        //Check Armor-Piercing
        //pAttacker.sendMessage(new TextComponent(Integer.toString(pTarget.invulnerableTime)), pAttacker.getUUID());
        if(pArmorPiercing > 0) {
            if(random.nextFloat() <= pArmorPierceChance) {
                if(pLastCharge == 1 || pCharge == 1) {
                    actuallyHurt(DamageSource.GENERIC, pArmorPiercing, pTarget, pAttacker);
                }
            }
        }



        pTarget.invulnerableTime = pInvincibilityTime;
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        return super.getDestroySpeed(pStack, pState) * pMineSpeedX;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        //Versatile Display
        pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.versatile"));
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.versatile.desc.axe"));
        }

        //Two-Handed Display
        if(pIsTwoHanded) {
            int twoHanded = pStack.getTag().getInt("dixtas_armory.two_handed");
            if(twoHanded == 1)
                pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.two_handed.1.blocked_light"));
            else if(twoHanded == 2) {
                if(pLevelTwoHanded == 1) {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.two_handed.1.blocked"));
                } else {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.two_handed.2.blocked"));
                }

            } else {
                if(pLevelTwoHanded == 1) {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.two_handed.1"));
                } else {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.two_handed.2"));
                }
            }
            if(Screen.hasShiftDown()) {
                if(pLevelTwoHanded == 1) {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.two_handed.1.desc"));
                } else {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.two_handed.2.desc"));
                }
            }
        }


        //Armor Piercing Display
        if(pArmorPiercing > 0) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.armor_piercing"));
            if(Screen.hasShiftDown()) {
                if(pArmorPierceChance == 0 || pArmorPierceChance == 1) {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.armor_piercing.desc", pArmorPiercing).withStyle(ChatFormatting.GRAY));
                } else {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.armor_piercing.desc.chance", (int)(pArmorPierceChance * 100), "%",pArmorPiercing).withStyle(ChatFormatting.GRAY));
                }
            }
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

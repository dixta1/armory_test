package net.dixta.dixtas_armory.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class AdvancedSwordItem extends SwordItem {
    public static UUID weaponRangeUUID = UUID.fromString("83a4286a-fdbb-4c91-b01a-64b3ddaec64e");
    public static UUID weaponKnockbackUUID = UUID.fromString("0627f79d-d31b-4d18-b645-25952e483585");
    public double pAttackRange;
    public double pAttackSpeed;
    boolean pIsTwoHanded;
    int pLevelTwoHanded;
    float pArmorPiercing;
    float pArmorPierceChance;
    float pSweepBoxX;
    float pSweepBoxY;
    float pSweepBoxZ;
    boolean pSweep;
    float pAttackKnockback;
    float pTwoHandedIDamage;
    float pTwoHandedIIDamage;
    float pTwoHandedISpeed;
    float pTwoHandedIISpeed;
    float pDamageSweep;
    double pCharge;
    double pLastCharge;
    float pUnarmoredDamage;
    int pInvincibilityTime;
    Random random = new Random();

    public AdvancedSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, double pAttackRangeModifier, float pArmorPiercingModifier,float pArmorPiercingChance, float pKnockback, float pUnarmoredBonus, int pTwoHandedLevel, int pMinorlyReducedDamage, int pMajorlyReducedDamage, float pMinorlyReducedSpeed, float pMajorlyReducedSpeed, int pInvulnerabilityTime, boolean pCanSweep, float pSweepDamage, float pSweepHitBoxX, float pSweepHitBoxY, float pSweepHitBoxZ) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        pAttackRange = pAttackRangeModifier - 3;
        pIsTwoHanded = (pTwoHandedLevel > 0);
        pLevelTwoHanded = pTwoHandedLevel;
        pArmorPiercing = pArmorPiercingModifier;
        pSweepBoxX = pSweepHitBoxX;
        pSweepBoxY = pSweepHitBoxY;
        pSweepBoxZ = pSweepHitBoxZ;
        pSweep = pCanSweep;
        pAttackKnockback = pKnockback;
        pAttackSpeed = pAttackSpeedModifier;
        pTwoHandedISpeed = (float)pAttackSpeed - pMinorlyReducedSpeed;
        pTwoHandedIISpeed = (float)pAttackSpeed - pMajorlyReducedSpeed;
        pTwoHandedIDamage = getDamage() - pMinorlyReducedDamage;
        pTwoHandedIIDamage = getDamage() - pMajorlyReducedDamage;
        pDamageSweep = pSweepDamage;
        pArmorPierceChance = pArmorPiercingChance;
        pUnarmoredDamage = pUnarmoredBonus;
        pInvincibilityTime = pInvulnerabilityTime;
    }



    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if(slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", findDamage(stack), AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", findSpeed(stack), AttributeModifier.Operation.ADDITION));
            builder.put(ForgeMod.ATTACK_RANGE.get(), new AttributeModifier(weaponRangeUUID, "Tool modifier", pAttackRange, AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(weaponKnockbackUUID, "Knockback modifier", pAttackKnockback, AttributeModifier.Operation.ADDITION));
            return builder.build();

        }
        return super.getAttributeModifiers(slot, stack);
    }

    float findDamage(ItemStack stack) {
        switch(stack.getTag().getInt("dixtas_armory.two_handed")) {
            case 1:
                return pTwoHandedIDamage;
            case 2:
                return pTwoHandedIIDamage;

            default:
                return getDamage();
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

    @NotNull
    @Override
    public AABB getSweepHitBox(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity target) {
        if(pDamageSweep == 0)
            return target.getBoundingBox().inflate(1.0D * pSweepBoxX, 0.25D * pSweepBoxY, 1.0D * pSweepBoxZ);
        else {
            for(LivingEntity livingentity : player.level.getEntitiesOfClass(LivingEntity.class, target.getBoundingBox().inflate(1.0D * pSweepBoxX, 0.25D * pSweepBoxY, 1.0D * pSweepBoxZ))) {
                if (livingentity != player && livingentity != target && !player.isAlliedTo(livingentity) && (!(livingentity instanceof ArmorStand) || !((ArmorStand)livingentity).isMarker()) && player.canHit(livingentity, 0)) { // Original check was dist < 3, range is 3, so vanilla used padding=0
                    livingentity.knockback((double)0.4F, (double) Mth.sin(player.getYRot() * ((float)Math.PI / 180F)), (double)(-Mth.cos(player.getYRot() * ((float)Math.PI / 180F))));
                    livingentity.hurt(DamageSource.playerAttack(player), pDamageSweep);
                }
            }

            return target.getBoundingBox().inflate(0,0,0);
        }
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

    private void twoHanded(LivingEntity pPlayer, ItemStack pStack) {
        if(pIsTwoHanded)
        {
            pStack.getOrCreateTag().putInt("dixtas_armory.two_handed", -1);

            if (pPlayer.getMainHandItem() == pStack && !pPlayer.getOffhandItem().getItem().equals(Items.AIR))
            {
                if(pLevelTwoHanded == 2 || checkHeavy(pPlayer.getOffhandItem()))
                    pStack.getOrCreateTag().putInt("dixtas_armory.two_handed", 2);
                else
                    pStack.getOrCreateTag().putInt("dixtas_armory.two_handed", 1);
            }
            else if (pPlayer.getOffhandItem() == pStack && !pPlayer.getMainHandItem().getItem().equals(Items.AIR))
            {
                if(pLevelTwoHanded == 2 || checkHeavy(pPlayer.getMainHandItem()))
                    pStack.getOrCreateTag().putInt("dixtas_armory.two_handed", 2);
                else
                    pStack.getOrCreateTag().putInt("dixtas_armory.two_handed", 1);
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



    boolean noArmor(LivingEntity pEntity) {
        return !(hasHelmet(pEntity) || hasChestplate(pEntity) || hasLeggings(pEntity) || hasBoots(pEntity));
    }
    boolean hasHelmet(LivingEntity pEntity) {
        return !(pEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Items.AIR);
    }
    boolean hasChestplate(LivingEntity pEntity) {
        return !(pEntity.getItemBySlot(EquipmentSlot.CHEST).getItem() == Items.AIR);
    }
    boolean hasLeggings(LivingEntity pEntity) {
        return !(pEntity.getItemBySlot(EquipmentSlot.LEGS).getItem() == Items.AIR);
    }
    boolean hasBoots(LivingEntity pEntity) {
        return !(pEntity.getItemBySlot(EquipmentSlot.FEET).getItem() == Items.AIR);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        //Check Armor-Piercing
        //pAttacker.sendMessage(new TextComponent(Integer.toString(pTarget.invulnerableTime)), pAttacker.getUUID());
        if(pArmorPiercing > 0) {
            if(random.nextFloat() <= pArmorPierceChance) {
                if(pLastCharge == 1 || pCharge == 1) {
                    actuallyHurt(DamageSource.GENERIC, pArmorPiercing, pTarget, pAttacker);
                }
            }
        }
        //Check Unarmored Damage
        else if (pUnarmoredDamage > 0 && noArmor(pTarget)) {
            actuallyHurt(DamageSource.GENERIC, pUnarmoredDamage, pTarget, pAttacker);
        }



        pTarget.invulnerableTime = pInvincibilityTime;


        return super.hurtEnemy(pStack,pTarget,pAttacker);
    }


    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        if(pSweep) {
            return super.canPerformAction(stack,toolAction);
        }
        else {
            return false;
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {


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

        //Quick Strike Display
        if(pInvincibilityTime != 20) {
            if(pInvincibilityTime < 20)  {

                pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.quick_strike"));
                if(Screen.hasShiftDown()) {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.quick_strike.desc", ((float)(pInvincibilityTime - 10) / 20)).withStyle(ChatFormatting.GRAY));

                }
            } else {
                pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.slow_strike"));
                if (Screen.hasShiftDown()) {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.slow_strike.desc",((float)(pInvincibilityTime - 10) / 20)).withStyle(ChatFormatting.GRAY));
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

        //Unarmored Damage Display
        if(pUnarmoredDamage > 0) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.unarmored_bonus"));
            if(Screen.hasShiftDown()) {
                pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.unarmored_bonus.desc", pUnarmoredDamage).withStyle(ChatFormatting.GRAY));
            }
        }


        //Sweeping Display
        if(pSweep ) {
            if(pDamageSweep != 0 && pDamageSweep != 1 || pSweepBoxX != 1) {
                pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.sweeping"));

                if(Screen.hasShiftDown()) {
                    //Sweeping Damage Display
                    if(pDamageSweep != 0 && pDamageSweep != 1) {
                        pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.sweeping_damage.desc", pDamageSweep).withStyle(ChatFormatting.GRAY));
                    }
                    //Sweeping Radius Display
                    if(pSweepBoxX != 1 ) {
                        pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.sweeping_radius.desc", pSweepBoxX).withStyle(ChatFormatting.GRAY));
                    }
                }

            }
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}

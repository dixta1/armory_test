package net.dixta.dixtas_armory.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.dixta.dixtas_armory.item.custom.attributes.AttackAttribute;
import net.dixta.dixtas_armory.item.custom.attributes.SweepAttribute;
import net.dixta.dixtas_armory.item.custom.attributes.TwoHandedAttribute;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.fml.ModList;
import org.infernalstudios.shieldexp.events.ShieldExpansionEvents;
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
    boolean pCanSweep;
    float pAttackKnockback;
    float pTwoHandedIDamage;
    float pTwoHandedIIDamage;
    float pTwoHandedISpeed;
    float pTwoHandedIISpeed;
    float pDamageSweep;


    float pUnarmoredDamage;
    int pInvincibilityTime;
    float pShieldCooldown;
    Random random = new Random();

    public AdvancedSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, double pAttackRangeModifier, AttackAttribute pAttackAttribute, TwoHandedAttribute pTwoHandedValues, SweepAttribute pSweep) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);

        //Default Attributes
        pAttackRange = pAttackRangeModifier - 3;
        pAttackSpeed = pAttackSpeedModifier - 4;

        //Two-Handed
        pIsTwoHanded = pTwoHandedValues.level > 0;
        pLevelTwoHanded = pTwoHandedValues.level;
        pTwoHandedISpeed = (float)pAttackSpeed - pTwoHandedValues.minSpeed;
        pTwoHandedIISpeed = (float)pAttackSpeed -  pTwoHandedValues.majSpeed;
        pTwoHandedIDamage = getDamage() - pTwoHandedValues.minDamage;
        pTwoHandedIIDamage = getDamage() - pTwoHandedValues.majDamage;

        //Sweep
        pSweepBoxX = pSweep.sweepRadiusX;
        pSweepBoxY = pSweep.sweepRadiusX;
        pSweepBoxZ = pSweep.sweepRadiusX;
        pCanSweep = pSweep.canSweep;
        pDamageSweep = pSweep.sweepDamage;

        //Attack
        pAttackKnockback = pAttackAttribute.knockback;
        pArmorPierceChance =pAttackAttribute.armorPiercingChance;
        pArmorPiercing = pAttackAttribute.armorPiercingAmount;
        pUnarmoredDamage = pAttackAttribute.unarmoredBonusDamage;
        pInvincibilityTime = pAttackAttribute.invincibilityTime;
        pShieldCooldown = pAttackAttribute.breachTime;





    }


    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {

        if(entity instanceof Player) {
            if(pShieldCooldown > 0) {
                if(ModList.get().isLoaded("shieldexp")) {
                    ((Player)entity).getCooldowns().addCooldown(entity.getUseItem().getItem(), (int)(ShieldExpansionEvents.getShieldValue(shield.getItem(),"cooldownTicks")  * pShieldCooldown));
                } else {
                    ((Player)entity).getCooldowns().addCooldown(entity.getUseItem().getItem(), (int)((float)100 * pShieldCooldown));
                }


                entity.stopUsingItem();
                entity.level.broadcastEntityEvent(entity, (byte)30);
            }
        }

        return false;
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
        return switch (stack.getTag().getInt("dixtas_armory.two_handed")) {
            case 1 -> pTwoHandedIDamage;
            case 2 -> pTwoHandedIIDamage;
            default -> getDamage();
        };
    }

    float findSpeed(ItemStack stack) {
        return switch (stack.getTag().getInt("dixtas_armory.two_handed")) {
            case 1 -> pTwoHandedISpeed;
            case 2 -> pTwoHandedIISpeed;
            default -> (float) pAttackSpeed;
        };
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

    boolean isTwoHanded(ItemStack pStack) {
        try {
            int i = pStack.getTag().getInt("dixtas_armory.two_handed");
            return i != 0;
        }
        catch(Exception error) {
            return false;
        }
    }

    boolean stackHeavy (ItemStack pStack){
        return pStack.is(ItemTags.create(new ResourceLocation("dixtas_armory:two_handed_heavy")));
    }

    boolean checkHeavy(ItemStack pStack) {


        return isTwoHanded(pStack) || stackHeavy(pStack);
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
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(pArmorPiercing > 0 || pUnarmoredDamage > 0) {
            boolean critical = player.getAttackStrengthScale(0.5F) == 1 && player.fallDistance > 0.0F && !player.isOnGround() && !player.onClimbable() && !player.isInWater() && !player.hasEffect(MobEffects.BLINDNESS) && !player.isPassenger() && entity instanceof LivingEntity;
            critical = critical && !player.isSprinting();
            stack.getOrCreateTag().putBoolean("dixtas_armory.attack.charged", player.getAttackStrengthScale(0.5F) > 0.9);
            stack.getOrCreateTag().putBoolean("dixtas_armory.attack.crit", critical);
        }


        return super.onLeftClickEntity(stack, player, entity);
    }


    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        boolean charged = false;
        boolean crit = false;
        if(pArmorPiercing > 0 || pUnarmoredDamage > 0) {
            assert pStack.getTag() != null;
            charged = pStack.getTag().getBoolean("dixtas_armory.attack.charged");
            crit = pStack.getTag().getBoolean("dixtas_armory.attack.crit");
        }


        //Check Armor-Piercing
        if(pArmorPiercing > 0) {
            if(random.nextFloat() <= pArmorPierceChance) {
                if(charged) {
                    float damage = pArmorPiercing;
                    if(crit)
                        damage *= 1.5;
                    actuallyHurt(DamageSource.GENERIC, damage, pTarget, pAttacker);
                }
            }
        }
        //Check Unarmored Damage
        else if (pUnarmoredDamage > 0 && noArmor(pTarget) && charged) {
            float damage = pUnarmoredDamage;
            if(crit)
                damage *= 1.5;
            actuallyHurt(DamageSource.GENERIC, damage, pTarget, pAttacker);
        }

        pTarget.invulnerableTime = pInvincibilityTime;


        return super.hurtEnemy(pStack,pTarget,pAttacker);
    }




    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        if(pCanSweep) {
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




        if(!ModList.get().isLoaded("shieldexp"))
        //Breach Display
        if(pShieldCooldown > 0) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.breach"));
            if(Screen.hasShiftDown()) {
                if(ModList.get().isLoaded("shieldexp")) {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.breach.desc.shieldexp", pShieldCooldown).withStyle(ChatFormatting.GRAY));
                } else {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.dixtas_armory.breach.desc.vanilla", 5 * pShieldCooldown).withStyle(ChatFormatting.GRAY));
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
        if(pCanSweep ) {
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

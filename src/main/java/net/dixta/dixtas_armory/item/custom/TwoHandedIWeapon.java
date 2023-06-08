package net.dixta.dixtas_armory.item.custom;

import net.dixta.dixtas_armory.item.custom.attributes.AttackAttribute;
import net.dixta.dixtas_armory.item.custom.attributes.SweepAttribute;
import net.dixta.dixtas_armory.item.custom.attributes.TwoHandedAttribute;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;

public class TwoHandedIWeapon extends AdvancedSwordItem{
    public TwoHandedIWeapon(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, double pAttackRangeModifier, AttackAttribute pAttackAttribute, TwoHandedAttribute pTwoHandedValues, SweepAttribute pSweep, Item switchItem) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties, pAttackRangeModifier, pAttackAttribute, pTwoHandedValues, pSweep, switchItem);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pEntity instanceof Player && !pLevel.isClientSide  ) {
            Player p = (Player) pEntity;
            if(p.getMainHandItem() == pStack ) {
                if(ModList.get().isLoaded("bettercombat") && pLevelTwoHanded == 1) {
                    if(!checkHeavy(p.getInventory().getItem(40)) && p.getInventory().getItem(40).getItem() != Items.AIR) {
                        switchItem(pStack, p);
                    }
                } else {
                    switchItem(pStack, p);
                }
            }
        }

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    void switchItem(ItemStack pStack, Player p) {
        ItemStack pNew = new ItemStack(pSwitchItem);
        pNew.setTag(pStack.getTag());
        p.setItemInHand(InteractionHand.MAIN_HAND, pNew);
    }
}

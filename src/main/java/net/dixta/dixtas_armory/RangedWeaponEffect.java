/*package net.dixta.dixtas_armory;
import net.dixta.dixtas_armory.item.custom.AdvancedAxeItem;
import net.dixta.dixtas_armory.item.custom.AdvancedSwordItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class RangedWeaponEffect {
    @SubscribeEvent
    public void onSpear(@NotNull LivingEquipmentChangeEvent event) {
        Player player = event.getEntityLiving() instanceof Player play ? play : null;
        if (player != null) {
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof AdvancedSwordItem) {
                player.getAttribute(ForgeMod.ATTACK_RANGE.get()).removeModifier(AdvancedSwordItem.weaponRangeUUID);
                player.getAttribute(ForgeMod.ATTACK_RANGE.get()).addPermanentModifier(new AttributeModifier(AdvancedSwordItem.weaponRangeUUID,"Weapon Range Modifier", ((AdvancedSwordItem) player.getItemBySlot(EquipmentSlot.MAINHAND).getItem()).pAttackRange, AttributeModifier.Operation.ADDITION));
            } else {
                player.getAttribute(ForgeMod.ATTACK_RANGE.get()).removeModifier(AdvancedSwordItem.weaponRangeUUID);
            }
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof AdvancedAxeItem) {
                player.getAttribute(ForgeMod.ATTACK_RANGE.get()).removeModifier(AdvancedAxeItem.weaponRangeUUID);
                player.getAttribute(ForgeMod.ATTACK_RANGE.get()).addPermanentModifier(new AttributeModifier(AdvancedAxeItem.weaponRangeUUID,"Weapon Range Modifier", ((AdvancedAxeItem) player.getItemBySlot(EquipmentSlot.MAINHAND).getItem()).pAttackRange, AttributeModifier.Operation.ADDITION));
            } else {
                player.getAttribute(ForgeMod.ATTACK_RANGE.get()).removeModifier(AdvancedAxeItem.weaponRangeUUID);
            }
        }
    }
}
*/
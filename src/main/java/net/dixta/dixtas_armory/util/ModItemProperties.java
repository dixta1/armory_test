package net.dixta.dixtas_armory.util;

import net.dixta.dixtas_armory.item.ModItems;
import net.dixta.dixtas_armory.item.OreganizedItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;

public class ModItemProperties {
    public static void addCustomItemProperties() {

    }

    private static void makeShield(Item item) {
        ItemProperties.register(item, new ResourceLocation("blocking"), (p_174590_, p_174591_, p_174592_, p_174593_) -> {
            return p_174592_ != null && p_174592_.isUsingItem() && p_174592_.getUseItem() == p_174590_ ? 1.0F : 0.0F;
        });
    }
}

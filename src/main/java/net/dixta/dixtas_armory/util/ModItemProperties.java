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
        makeShield(ModItems.WOODEN_SHIELD.get());
        makeShield(ModItems.STONE_SHIELD.get());
        makeShield(ModItems.GOLDEN_SHIELD.get());
        makeShield(ModItems.IRON_SHIELD.get());
        makeShield(ModItems.DIAMOND_SHIELD.get());
        makeShield(ModItems.NETHERITE_SHIELD.get());
        if(ModList.get().isLoaded("oreganized"))
            makeShield(OreganizedItems.ELECTRUM_SHIELD.get());


        makeShield(ModItems.WOODEN_TOWER_SHIELD.get());
        makeShield(ModItems.STONE_TOWER_SHIELD.get());
        makeShield(ModItems.GOLDEN_TOWER_SHIELD.get());
        makeShield(ModItems.IRON_TOWER_SHIELD.get());
        makeShield(ModItems.DIAMOND_TOWER_SHIELD.get());
        makeShield(ModItems.NETHERITE_TOWER_SHIELD.get());
        if(ModList.get().isLoaded("oreganized"))
            makeShield(OreganizedItems.ELECTRUM_TOWER_SHIELD.get());
    }

    private static void makeShield(Item item) {
        ItemProperties.register(item, new ResourceLocation("blocking"), (p_174590_, p_174591_, p_174592_, p_174593_) -> {
            return p_174592_ != null && p_174592_.isUsingItem() && p_174592_.getUseItem() == p_174590_ ? 1.0F : 0.0F;
        });
    }
}

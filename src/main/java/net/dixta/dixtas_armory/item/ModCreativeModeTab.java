package net.dixta.dixtas_armory.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab WEAPONS_TAB = new CreativeModeTab("armory") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DIAMOND_BATTLE_AXE.get());
        }
    };
}

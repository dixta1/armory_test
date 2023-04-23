package net.dixta.dixtas_armory.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier DIAMOND = new ForgeTier(3, 1561, 8.0f,3.0f,10, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.DIAMOND));
}

package net.dixta.dixtas_armory.item;


//import galena.oreganized.index.OItemTiers;
import net.dixta.dixtas_armory.DixtasArmory;
import net.dixta.dixtas_armory.item.custom.AdvancedAxeItem;
import net.dixta.dixtas_armory.item.custom.AdvancedSwordItem;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OreganizedItems {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, DixtasArmory.MOD_ID);




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

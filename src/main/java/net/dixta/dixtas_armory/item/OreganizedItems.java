package net.dixta.dixtas_armory.item;


import galena.oreganized.index.OItemTiers;
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



    //Electrum
    //Bladed Weapons
    public static final RegistryObject<Item> ELECTRUM_DAGGER = ITEMS.register("electrum_dagger",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 3, -0.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 1.5, 0,0,0,0,0,0,0,0,0, 15,true, 0,0.25f,1,0.25f));

    public static final RegistryObject<Item> ELECTRUM_SHORTSWORD = ITEMS.register("electrum_shortsword",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 4, -2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 2.25, 0,0,0,0,0,0,0,0,0, 20,true, 0, 0.25f,0.25f,0.25f));

    public static final RegistryObject<Item> ELECTRUM_STILETTO = ITEMS.register("electrum_stiletto",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> ELECTRUM_RAPIER = ITEMS.register("electrum_rapier",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> ELECTRUM_KATANA = ITEMS.register("electrum_katana",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> ELECTRUM_GREATSWORD = ITEMS.register("electrum_greatsword",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> ELECTRUM_LONGSWORD = ITEMS.register("electrum_longsword",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> ELECTRUM_TWINBLADE = ITEMS.register("electrum_twinblade",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> ELECTRUM_ZWEIHANDER = ITEMS.register("electrum_zweihander",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 7, -3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  5, 0,0,0,0, 2,0,5,0, 0.5f,20, true, 5, 2f,1f,2f));

    //Axes
    public static final RegistryObject<Item> ELECTRUM_BATTLE_AXE = ITEMS.register("electrum_battle_axe",
            () -> new AdvancedAxeItem(OItemTiers.ELECTRUM, 11, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 0,1,2,5,0.1f,0.25f, 20,1,0.5f));

    //Pole-Arms
    public static final RegistryObject<Item> ELECTRUM_GLAIVE = ITEMS.register("electrum_glaive",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 5, -2.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, 0,0,0, 0,2,0,5,0, 0.5f,20, true, 5, 1f,1f,1f));

    public static final RegistryObject<Item> ELECTRUM_SPEAR = ITEMS.register("electrum_spear",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> ELECTRUM_HALBERD = ITEMS.register("electrum_halberd",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> ELECTRUM_PIKE = ITEMS.register("electrum_pike",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 4, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, 3,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

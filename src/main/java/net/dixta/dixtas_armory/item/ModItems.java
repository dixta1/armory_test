package net.dixta.dixtas_armory.item;

import galena.oreganized.index.OItemTiers;
import net.dixta.dixtas_armory.DixtasArmory;
import net.dixta.dixtas_armory.item.custom.AdvancedAxeItem;
import net.dixta.dixtas_armory.item.custom.AdvancedSwordItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, DixtasArmory.MOD_ID);

    public static final RegistryObject<Item> POLE = ITEMS.register("pole",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB)));


    public static final RegistryObject<Item> WOODEN_DAGGER = ITEMS.register("wooden_dagger",
            () -> new AdvancedSwordItem(Tiers.WOOD, 3, -0.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),1.5,0, 0,0,0,0,0,0,0,0,15,true,0,0.25f,1,0.25f));

   public static final RegistryObject<Item> WOODEN_SHORTSWORD = ITEMS.register("wooden_shortsword",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 0,0,0,0,0,0,1,0.5f,20,true,0,0.75f,1,0.75f));

    public static final RegistryObject<Item> WOODEN_STILETTO = ITEMS.register("wooden_stiletto",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3,0, 1,0,0,0,0,0,0,0,20,false,0,0,0,0));

    public static final RegistryObject<Item> WOODEN_RAPIER = ITEMS.register("wooden_rapier",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3,0, 0,0,0,0,0,0,1,0.5f, 20,true,0,1,1,1));

    public static final RegistryObject<Item> WOODEN_KATANA = ITEMS.register("wooden_katana",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 0,0,0,0,0,0,1,0.5f,20,true, 0,1,1,1));

    public static final RegistryObject<Item> WOODEN_GREATSWORD = ITEMS.register("wooden_greatsword",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 0,0,0,0,0,0,0,20,0,true,0,1,1,1));

    public static final RegistryObject<Item> WOODEN_LONGSWORD = ITEMS.register("wooden_longsword",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 0,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> WOODEN_TWINBLADE = ITEMS.register("wooden_twinblade",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 0,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> WOODEN_ZWEIHANDER = ITEMS.register("wooden_zweihander",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 0,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));


    public static final RegistryObject<Item> WOODEN_BATTLE_AXE = ITEMS.register("wooden_battle_axe",
            () -> new AdvancedAxeItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,0,0,0,0, 20,1, 20.5f));


    public static final RegistryObject<Item> WOODEN_GLAIVE = ITEMS.register("wooden_glaive",
            () -> new AdvancedSwordItem(Tiers.WOOD, 5, -3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, 0,0,0, 0,2,0,5,0, 0.5f,20, true, 5, 1f,1f,1f));

    public static final RegistryObject<Item> WOODEN_SPEAR = ITEMS.register("wooden_spear",
            () -> new AdvancedSwordItem(Tiers.WOOD, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> WOODEN_HALBERD = ITEMS.register("wooden_halberd",
            () -> new AdvancedSwordItem(Tiers.WOOD, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> WOODEN_PIKE = ITEMS.register("wooden_pike",
            () -> new AdvancedSwordItem(Tiers.WOOD, 4, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, 3,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));


 public static final RegistryObject<Item> STONE_DAGGER = ITEMS.register("stone_dagger",
            () -> new AdvancedSwordItem(Tiers.STONE, 3, -0.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),1.5,0,0,0,0,0,0,0,0,0,15,true,0,0.25f,1,0.25f));

    public static final RegistryObject<Item> STONE_SHORTSWORD = ITEMS.register("stone_shortsword",
            () -> new AdvancedSwordItem(Tiers.STONE, 4, -2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2.25,0,0,0,0,0,0,0,0,0,20,true,0,0.75f,1,0.75f));

    public static final RegistryObject<Item> STONE_STILETTO = ITEMS.register("stone_stiletto",
            () -> new AdvancedSwordItem(Tiers.STONE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> STONE_RAPIER = ITEMS.register("stone_rapier",
            () -> new AdvancedSwordItem(Tiers.STONE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> STONE_KATANA = ITEMS.register("stone_katana",
            () -> new AdvancedSwordItem(Tiers.STONE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> STONE_GREATSWORD = ITEMS.register("stone_greatsword",
            () -> new AdvancedSwordItem(Tiers.STONE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> STONE_LONGSWORD = ITEMS.register("stone_longsword",
            () -> new AdvancedSwordItem(Tiers.STONE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> STONE_TWINBLADE = ITEMS.register("stone_twinblade",
            () -> new AdvancedSwordItem(Tiers.STONE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> STONE_ZWEIHANDER = ITEMS.register("stone_zweihander",
            () -> new AdvancedSwordItem(Tiers.STONE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));


    public static final RegistryObject<Item> STONE_BATTLE_AXE = ITEMS.register("stone_battle_axe",
            () -> new AdvancedAxeItem(Tiers.STONE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0,1,0,0,0,0, 20,1,0.5f));


    public static final RegistryObject<Item> STONE_GLAIVE = ITEMS.register("stone_glaive",
            () -> new AdvancedSwordItem(Tiers.STONE, 5, -3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, 0,0,0, 0,2,0,5,0, 0.5f,20, true, 5, 1f,1f,1f));

    public static final RegistryObject<Item> STONE_SPEAR = ITEMS.register("stone_spear",
            () -> new AdvancedSwordItem(Tiers.STONE, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> STONE_HALBERD = ITEMS.register("stone_halberd",
            () -> new AdvancedSwordItem(Tiers.STONE, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> STONE_PIKE = ITEMS.register("stone_pike",
            () -> new AdvancedSwordItem(Tiers.STONE, 4, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, 3,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));





 public static final RegistryObject<Item> GOLDEN_DAGGER = ITEMS.register("golden_dagger",
            () -> new AdvancedSwordItem(Tiers.WOOD, 3, -0.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),1.5,0, 0,0,0,0,0,0,0,0,15,true,0,0.25f,1,0.25f));

    public static final RegistryObject<Item> GOLDEN_SHORTSWORD = ITEMS.register("golden_shortsword",
            () -> new AdvancedSwordItem(Tiers.WOOD, 4, -2, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2.25,0, 0,0,0,0,0,0,0,0,20,true,0,0.75f,1,0.75f));

    public static final RegistryObject<Item> GOLDEN_STILETTO = ITEMS.register("golden_stiletto",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 1,0,0,0,0,0,0,0,20,true,0,1,1,1));

    public static final RegistryObject<Item> GOLDEN_RAPIER = ITEMS.register("golden_rapier",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3,0, 1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> GOLDEN_KATANA = ITEMS.register("golden_katana",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> GOLDEN_GREATSWORD = ITEMS.register("golden_greatsword",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> GOLDEN_LONGSWORD = ITEMS.register("golden_longsword",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> GOLDEN_TWINBLADE = ITEMS.register("golden_twinblade",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> GOLDEN_ZWEIHANDER = ITEMS.register("golden_zweihander",
            () -> new AdvancedSwordItem(Tiers.WOOD, 12, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0, 1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));


    public static final RegistryObject<Item> GOLDEN_BATTLE_AXE = ITEMS.register("golden_battle_axe",
            () -> new AdvancedAxeItem(Tiers.GOLD, 12, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,0,0,0,0, 20,1,0.5f));


    public static final RegistryObject<Item> GOLDEN_GLAIVE = ITEMS.register("golden_glaive",
            () -> new AdvancedSwordItem(Tiers.GOLD, 5, -3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, 0,0,0, 0,2,0,5,0, 0.5f,20, true, 5, 1f,1f,1f));

    public static final RegistryObject<Item> GOLDEN_SPEAR = ITEMS.register("golden_spear",
            () -> new AdvancedSwordItem(Tiers.GOLD, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> GOLDEN_HALBERD = ITEMS.register("golden_halberd",
            () -> new AdvancedSwordItem(Tiers.GOLD, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> GOLDEN_PIKE = ITEMS.register("golden_pike",
            () -> new AdvancedSwordItem(Tiers.GOLD, 4, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, 3,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));




 public static final RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger",
            () -> new AdvancedSwordItem(Tiers.IRON, 3, -0.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),1.5,0,0,0,0,0,0,0,0,0,15,true,0,0.25f,1,0.25f));

    public static final RegistryObject<Item> IRON_SHORTSWORD = ITEMS.register("iron_shortsword",
            () -> new AdvancedSwordItem(Tiers.IRON, 4, -2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2.25,0,0,0,0,0,0,0,0,0,20,true,0,0.75f,1,0.75f));

    public static final RegistryObject<Item> IRON_STILETTO = ITEMS.register("iron_stiletto",
            () -> new AdvancedSwordItem(Tiers.IRON, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> IRON_RAPIER = ITEMS.register("iron_rapier",
            () -> new AdvancedSwordItem(Tiers.IRON, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> IRON_KATANA = ITEMS.register("iron_katana",
            () -> new AdvancedSwordItem(Tiers.IRON, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> IRON_GREATSWORD = ITEMS.register("iron_greatsword",
            () -> new AdvancedSwordItem(Tiers.IRON, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> IRON_LONGSWORD = ITEMS.register("iron_longsword",
            () -> new AdvancedSwordItem(Tiers.IRON, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> IRON_TWINBLADE = ITEMS.register("iron_twinblade",
            () -> new AdvancedSwordItem(Tiers.IRON, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> IRON_ZWEIHANDER = ITEMS.register("iron_zweihander",
            () -> new AdvancedSwordItem(Tiers.IRON, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));


    public static final RegistryObject<Item> IRON_BATTLE_AXE = ITEMS.register("iron_battle_axe",
            () -> new AdvancedAxeItem(Tiers.IRON, 12, -3.55f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,0,0,0,0, 20,1,0.5f));


    public static final RegistryObject<Item> IRON_GLAIVE = ITEMS.register("iron_glaive",
            () -> new AdvancedSwordItem(Tiers.IRON, 5, -3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, 0,0,0, 0,2,0,5,0, 0.5f,20, true, 5, 1f,1f,1f));

    public static final RegistryObject<Item> IRON_SPEAR = ITEMS.register("iron_spear",
            () -> new AdvancedSwordItem(Tiers.IRON, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> IRON_HALBERD = ITEMS.register("iron_halberd",
            () -> new AdvancedSwordItem(Tiers.IRON, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> IRON_PIKE = ITEMS.register("iron_pike",
            () -> new AdvancedSwordItem(Tiers.IRON, 4, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, 3,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));






 public static final RegistryObject<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 3, -0.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 1.5, 0,0,0,0,0,0,0,0,0,15, true, 0,0.25f,1,0.25f));

    public static final RegistryObject<Item> DIAMOND_SHORTSWORD = ITEMS.register("diamond_shortsword",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 4, -2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 2.25, 0,0,0,0,0,0,0,0,0,20, true, 0, 0.75f,1,0.75f));

    public static final RegistryObject<Item> DIAMOND_STILETTO = ITEMS.register("diamond_stiletto",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 2, -1.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2.5,4,0.25f,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> DIAMOND_RAPIER = ITEMS.register("diamond_rapier",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 3, -2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3,0,1,0,5,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> DIAMOND_KATANA = ITEMS.register("diamond_katana",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> DIAMOND_GREATSWORD = ITEMS.register("diamond_greatsword",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> DIAMOND_LONGSWORD = ITEMS.register("diamond_longsword",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> DIAMOND_TWINBLADE = ITEMS.register("diamond_twinblade",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20,true,0,1,1,1));

    public static final RegistryObject<Item> DIAMOND_ZWEIHANDER = ITEMS.register("diamond_zweihander",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 7, -3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  5, 0,0,0, 0,2,0,5,0, 0.5f,20, true, 5, 2f,1f,2f));


    public static final RegistryObject<Item> DIAMOND_BATTLE_AXE = ITEMS.register("diamond_battle_axe",
            () -> new AdvancedAxeItem(Tiers.DIAMOND, 11, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,2,5,0.1f,0.25f, 20,1,0.5f));


    public static final RegistryObject<Item> DIAMOND_GLAIVE = ITEMS.register("diamond_glaive",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 5, -3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, 0,0,0, 0,2,0,5,0, 0.5f,20, true, 5, 1f,1f,1f));

    public static final RegistryObject<Item> DIAMOND_SPEAR = ITEMS.register("diamond_spear",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> DIAMOND_HALBERD = ITEMS.register("diamond_halberd",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> DIAMOND_PIKE = ITEMS.register("diamond_pike",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 4, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, 3,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));





    public static final RegistryObject<Item> NETHERITE_DAGGER = ITEMS.register("netherite_dagger",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 3, -0.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),1.5,0,0,0,0,0,0,0,0,0,15, true, 0,0.25f,1,0.25f));

    public static final RegistryObject<Item> NETHERITE_SHORTSWORD = ITEMS.register("netherite_shortsword",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 4, -2, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2.25,0,0,0,0,0,0,0,0,0, 20,true, 0,0.75f,0.75f,0.75f));

    public static final RegistryObject<Item> NETHERITE_STILETTO = ITEMS.register("netherite_stiletto",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f, 20,true, 0,0,0,0));

    public static final RegistryObject<Item> NETHERITE_RAPIER = ITEMS.register("netherite_rapier",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f, 20,true, 0,0,0,0));

    public static final RegistryObject<Item> NETHERITE_KATANA = ITEMS.register("netherite_katana",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f, 20,true, 0,0,0,0));

    public static final RegistryObject<Item> NETHERITE_GREATSWORD = ITEMS.register("netherite_greatsword",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f, 20,true, 0,0,0,0));

    public static final RegistryObject<Item> NETHERITE_LONGSWORD = ITEMS.register("netherite_longsword",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20, true, 0,0,0,0));

    public static final RegistryObject<Item> NETHERITE_TWINBLADE = ITEMS.register("netherite_twinblade",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f,20, true, 0,0,0,0));

    public static final RegistryObject<Item> NETHERITE_ZWEIHANDER = ITEMS.register("netherite_zweihander",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 13, -3.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,0,1,0,0,0,0,0,1,0.5f, 20,true, 0,0,0,0));


    public static final RegistryObject<Item> NETHERITE_BATTLE_AXE = ITEMS.register("netherite_battle_axe",
            () -> new AdvancedAxeItem(Tiers.NETHERITE, 11, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,0,0,0,0, 20,1, 0.5f));


    public static final RegistryObject<Item> NETHERITE_GLAIVE = ITEMS.register("netherite_glaive",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 5, -3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, 0,0,0, 0,2,0,5,0, 0.5f,20, true, 5, 1f,1f,1f));

    public static final RegistryObject<Item> NETHERITE_SPEAR = ITEMS.register("netherite_spear",
         () -> new AdvancedSwordItem(Tiers.NETHERITE, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> NETHERITE_HALBERD = ITEMS.register("netherite_halberd",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 4, -2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4, 4,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));

    public static final RegistryObject<Item> NETHERITE_PIKE = ITEMS.register("netherite_pike",
         () -> new AdvancedSwordItem(Tiers.NETHERITE, 4, -3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, 3,1, 0,0, 2,0,1,0,0.25f, 20,false,0, 0, 0, 0));











    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

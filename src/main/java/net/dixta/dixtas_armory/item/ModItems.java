package net.dixta.dixtas_armory.item;

import net.dixta.dixtas_armory.DixtasArmory;
import net.dixta.dixtas_armory.item.custom.AdvancedAxeItem;
import net.dixta.dixtas_armory.item.custom.AdvancedSwordItem;
import net.dixta.dixtas_armory.item.custom.TwoHandedIAxe;
import net.dixta.dixtas_armory.item.custom.TwoHandedIWeapon;
import net.dixta.dixtas_armory.item.custom.attributes.AttackAttribute;
import net.dixta.dixtas_armory.item.custom.attributes.SweepAttribute;
import net.dixta.dixtas_armory.item.custom.attributes.TwoHandedAttribute;
import net.dixta.dixtas_armory.item.custom.attributes.TwoHandedIIAttribute;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, DixtasArmory.MOD_ID);

    public static final RegistryObject<Item> POLE = ITEMS.register("pole",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB)));




    //WOOD
    //Bladed Weapons
    public static final RegistryObject<Item> WOODEN_DAGGER = ITEMS.register("wooden_dagger",
            () -> new AdvancedSwordItem(Tiers.WOOD, 2, 3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 1.8, new AttackAttribute(0,0,0,0,15,0,0), TwoHandedAttribute.none, new SweepAttribute(true, 1,0.25f)));

    public static final RegistryObject<Item> WOODEN_SHORTSWORD = ITEMS.register("wooden_shortsword",
            () -> new AdvancedSwordItem(Tiers.WOOD, 2, 2.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 2.25, AttackAttribute.none, TwoHandedAttribute.none, new SweepAttribute(true,1,0.75f)));

    public static final RegistryObject<Item> WOODEN_STILETTO = ITEMS.register("wooden_stiletto",
            () -> new AdvancedSwordItem(Tiers.WOOD, 2, 2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2, new AttackAttribute(0,0.25f,2,0,17,0,0), TwoHandedAttribute.none, SweepAttribute.none));

    public static final RegistryObject<Item> WOODEN_RAPIER = ITEMS.register("wooden_rapier",
            () -> new AdvancedSwordItem(Tiers.WOOD, 2, 2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3, new AttackAttribute(0,0,0,1,20,0,0), TwoHandedAttribute.none,SweepAttribute.normal));

    public static final RegistryObject<Item> WOODEN_KATANA = ITEMS.register("wooden_katana",
            () -> new AdvancedSwordItem(Tiers.WOOD, 3, 1.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,AttackAttribute.none,new TwoHandedAttribute(1,1,3,0.05f,1),new SweepAttribute(true,2,1.25f), Items.AIR));

    public static final RegistryObject<Item> WOODEN_KATANA_TWO_HANDED = ITEMS.register("wooden_katana_two_handed",
            () -> new TwoHandedIWeapon(Tiers.WOOD, 3, 1.8f, new Item.Properties(),3.25,AttackAttribute.none,new TwoHandedAttribute(1,1,3,0.05f,1),new SweepAttribute(true,2,1.25f), WOODEN_KATANA.get()));

    public static final RegistryObject<Item> WOODEN_GREATSWORD = ITEMS.register("wooden_greatsword",
            () -> new AdvancedSwordItem(Tiers.WOOD, 4, 1.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none,new TwoHandedIIAttribute(4,0.4f),new SweepAttribute(true, 3,1.5f)));

    public static final RegistryObject<Item> WOODEN_LONGSWORD = ITEMS.register("wooden_longsword",
            () -> new AdvancedSwordItem(Tiers.WOOD, 5, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(4,0.4f), new SweepAttribute(true, 1,2)));

    public static final RegistryObject<Item> WOODEN_TWINBLADE = ITEMS.register("wooden_twinblade",
            () -> new AdvancedSwordItem(Tiers.WOOD, 3, 1.9f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(4,0.4f),SweepAttribute.normal));

    public static final RegistryObject<Item> WOODEN_ZWEIHANDER = ITEMS.register("wooden_zweihander",
            () -> new AdvancedSwordItem(Tiers.WOOD, 4, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none,new TwoHandedIIAttribute(3,0.5f), new SweepAttribute(true,1,2.5f)));

    //Axes
    public static final RegistryObject<Item> WOODEN_BATTLE_AXE = ITEMS.register("wooden_battle_axe",
            () -> new AdvancedAxeItem(Tiers.WOOD, 10, -3.50f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,1,3,0.05f,0.25f, 20,1,0.5f, Items.AIR));

    public static final RegistryObject<Item> WOODEN_BATTLE_AXE_TWO_HANDED = ITEMS.register("wooden_battle_axe_two_handed",
            () -> new TwoHandedIAxe(Tiers.WOOD, 10, -3.50f, new Item.Properties(),3.25,0, 0, 1,1,3,0.05f,0.25f, 20,1,0.5f, WOODEN_BATTLE_AXE.get()));


    //Pole-Arms
    public static final RegistryObject<Item> WOODEN_GLAIVE = ITEMS.register("wooden_glaive",
            () -> new AdvancedSwordItem(Tiers.WOOD, 6, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none, new TwoHandedIIAttribute(4,0.5f), SweepAttribute.normal));

    public static final RegistryObject<Item> WOODEN_SPEAR = ITEMS.register("wooden_spear",
            () -> new AdvancedSwordItem(Tiers.WOOD, 2, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.2, new AttackAttribute(0,1,1,0,20,0,0), new TwoHandedAttribute(1,0,1,0.1f,0.55f), SweepAttribute.none, Items.AIR));

    public static final RegistryObject<Item> WOODEN_SPEAR_TWO_HANDED = ITEMS.register("wooden_spear_two_handed",
            () -> new TwoHandedIWeapon(Tiers.WOOD, 2, 1.3f, new Item.Properties(), 4.2, new AttackAttribute(0,1,1,0,20,0,0), new TwoHandedAttribute(1,0,1,0.1f,0.55f), SweepAttribute.none, WOODEN_SPEAR.get()));

    public static final RegistryObject<Item> WOODEN_HALBERD = ITEMS.register("wooden_halberd",
            () -> new AdvancedSwordItem(Tiers.WOOD, 7, 0.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.5, new AttackAttribute(0,0.5f,4,0,20,1.5f,1), new TwoHandedIIAttribute(3,0.2f), SweepAttribute.none));

    public static final RegistryObject<Item> WOODEN_PIKE = ITEMS.register("wooden_pike",
            () -> new AdvancedSwordItem(Tiers.WOOD, 5, 0.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, new AttackAttribute(0,1,1,0,20,0,0),new TwoHandedIIAttribute(2,0.3f), SweepAttribute.none));





    //STONE
    //Bladed Weapons
    public static final RegistryObject<Item> STONE_DAGGER = ITEMS.register("stone_dagger",
            () -> new AdvancedSwordItem(Tiers.STONE, 1, 3.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 1.8, new AttackAttribute(0,0,0,0,15,0,0), TwoHandedAttribute.none, new SweepAttribute(true, 1,0.25f)));

    public static final RegistryObject<Item> STONE_SHORTSWORD = ITEMS.register("stone_shortsword",
            () -> new AdvancedSwordItem(Tiers.STONE, 2, 2.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 2.25, AttackAttribute.none, TwoHandedAttribute.none, new SweepAttribute(true,1,0.75f)));

    public static final RegistryObject<Item> STONE_STILETTO = ITEMS.register("stone_stiletto",
            () -> new AdvancedSwordItem(Tiers.STONE, 1, 2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2, new AttackAttribute(0,0.25f,3,0,17,0,0), TwoHandedAttribute.none, SweepAttribute.none));

    public static final RegistryObject<Item> STONE_RAPIER = ITEMS.register("stone_rapier",
            () -> new AdvancedSwordItem(Tiers.STONE, 1, 2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3, new AttackAttribute(0,0,0,2,20,0,0), TwoHandedAttribute.none,SweepAttribute.normal));

    public static final RegistryObject<Item> STONE_KATANA = ITEMS.register("stone_katana",
            () -> new AdvancedSwordItem(Tiers.STONE, 3, 1.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,AttackAttribute.none,new TwoHandedAttribute(1,1,4,0.05f,1),new SweepAttribute(true,2,1.25f), Items.AIR));

    public static final RegistryObject<Item> STONE_KATANA_TWO_HANDED = ITEMS.register("stone_katana_two_handed",
            () -> new TwoHandedIWeapon(Tiers.STONE, 3, 1.8f, new Item.Properties(),3.25,AttackAttribute.none,new TwoHandedAttribute(1,1,4,0.05f,1),new SweepAttribute(true,2,1.25f), STONE_KATANA.get()));

    public static final RegistryObject<Item> STONE_GREATSWORD = ITEMS.register("stone_greatsword",
            () -> new AdvancedSwordItem(Tiers.STONE, 4, 1.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none,new TwoHandedIIAttribute(5,0.4f),new SweepAttribute(true, 3,1.5f)));

    public static final RegistryObject<Item> STONE_LONGSWORD = ITEMS.register("stone_longsword",
            () -> new AdvancedSwordItem(Tiers.STONE, 5, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(5,0.4f), new SweepAttribute(true, 1,2)));

    public static final RegistryObject<Item> STONE_TWINBLADE = ITEMS.register("stone_twinblade",
            () -> new AdvancedSwordItem(Tiers.STONE, 3, 1.9f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(5,0.4f),SweepAttribute.normal));

    public static final RegistryObject<Item> STONE_ZWEIHANDER = ITEMS.register("stone_zweihander",
            () -> new AdvancedSwordItem(Tiers.STONE, 4, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none,new TwoHandedIIAttribute(4,0.5f), new SweepAttribute(true,1,2.5f)));

    //Axes
    public static final RegistryObject<Item> STONE_BATTLE_AXE = ITEMS.register("stone_battle_axe",
            () -> new AdvancedAxeItem(Tiers.STONE, 12, -3.50f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,1,4,0.05f,0.25f, 20,1,0.5f, Items.AIR));

    public static final RegistryObject<Item> STONE_BATTLE_AXE_TWO_HANDED = ITEMS.register("stone_battle_axe_two_handed",
            () -> new TwoHandedIAxe(Tiers.STONE, 12, -3.50f, new Item.Properties(),3.25,0, 0, 1,1,4,0.05f,0.25f, 20,1,0.5f, STONE_BATTLE_AXE.get()));


    //Pole-Arms
    public static final RegistryObject<Item> STONE_GLAIVE = ITEMS.register("stone_glaive",
            () -> new AdvancedSwordItem(Tiers.STONE, 6, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none, new TwoHandedIIAttribute(4,0.5f), SweepAttribute.normal));

    public static final RegistryObject<Item> STONE_SPEAR = ITEMS.register("stone_spear",
            () -> new AdvancedSwordItem(Tiers.STONE, 2, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.2, new AttackAttribute(0,1,1,0,20,0,0), new TwoHandedAttribute(1,0,2,0.1f,0.55f), SweepAttribute.none,Items.AIR));

    public static final RegistryObject<Item> STONE_SPEAR_TWO_HANDED = ITEMS.register("stone_spear_two_handed",
            () -> new TwoHandedIWeapon(Tiers.STONE, 2, 1.3f, new Item.Properties(), 4.2, new AttackAttribute(0,1,1,0,20,0,0), new TwoHandedAttribute(1,0,2,0.1f,0.55f), SweepAttribute.none, STONE_SPEAR.get()));

    public static final RegistryObject<Item> STONE_HALBERD = ITEMS.register("stone_halberd",
            () -> new AdvancedSwordItem(Tiers.STONE, 8, 0.6f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.5, new AttackAttribute(0,0.5f,4,0,20,1.5f,1), new TwoHandedIIAttribute(4,0.2f), SweepAttribute.none));

    public static final RegistryObject<Item> STONE_PIKE = ITEMS.register("stone_pike",
            () -> new AdvancedSwordItem(Tiers.STONE, 5, 0.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, new AttackAttribute(0,1,1,0,20,0,0),new TwoHandedIIAttribute(3,0.3f), SweepAttribute.none));





    //GOLD
    //Bladed Weapons
    public static final RegistryObject<Item> GOLDEN_DAGGER = ITEMS.register("golden_dagger",
            () -> new AdvancedSwordItem(Tiers.GOLD, 2, 3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 1.8, new AttackAttribute(0,0,0,0,15,0,0), TwoHandedAttribute.none, new SweepAttribute(true, 1,0.25f)));

    public static final RegistryObject<Item> GOLDEN_SHORTSWORD = ITEMS.register("golden_shortsword",
            () -> new AdvancedSwordItem(Tiers.GOLD, 2, 2.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 2.25, AttackAttribute.none, TwoHandedAttribute.none, new SweepAttribute(true,1,0.75f)));

    public static final RegistryObject<Item> GOLDEN_STILETTO = ITEMS.register("golden_stiletto",
            () -> new AdvancedSwordItem(Tiers.GOLD, 2, 2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2, new AttackAttribute(0,0.25f,2,0,17,0,0), TwoHandedAttribute.none, SweepAttribute.none));

    public static final RegistryObject<Item> GOLDEN_RAPIER = ITEMS.register("golden_rapier",
            () -> new AdvancedSwordItem(Tiers.GOLD, 2, 2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3, new AttackAttribute(0,0,0,1,20,0,0), TwoHandedAttribute.none,SweepAttribute.normal));

    public static final RegistryObject<Item> GOLDEN_KATANA = ITEMS.register("golden_katana",
            () -> new AdvancedSwordItem(Tiers.GOLD, 3, 1.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,AttackAttribute.none,new TwoHandedAttribute(1,1,3,0.05f,1),new SweepAttribute(true,2,1.25f), Items.AIR));

    public static final RegistryObject<Item> GOLDEN_KATANA_TWO_HANDED = ITEMS.register("golden_katana_two_handed",
            () -> new TwoHandedIWeapon(Tiers.GOLD, 3, 1.8f, new Item.Properties(),3.25,AttackAttribute.none,new TwoHandedAttribute(1,1,3,0.05f,1),new SweepAttribute(true,2,1.25f), GOLDEN_KATANA.get()));

    public static final RegistryObject<Item> GOLDEN_GREATSWORD = ITEMS.register("golden_greatsword",
            () -> new AdvancedSwordItem(Tiers.GOLD, 4, 1.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none,new TwoHandedIIAttribute(4,0.4f),new SweepAttribute(true, 3,1.5f)));

    public static final RegistryObject<Item> GOLDEN_LONGSWORD = ITEMS.register("golden_longsword",
            () -> new AdvancedSwordItem(Tiers.GOLD, 5, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(4,0.4f), new SweepAttribute(true, 1,2)));

    public static final RegistryObject<Item> GOLDEN_TWINBLADE = ITEMS.register("golden_twinblade",
            () -> new AdvancedSwordItem(Tiers.GOLD, 3, 1.9f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(4,0.4f),SweepAttribute.normal));

    public static final RegistryObject<Item> GOLDEN_ZWEIHANDER = ITEMS.register("golden_zweihander",
            () -> new AdvancedSwordItem(Tiers.GOLD, 4, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none,new TwoHandedIIAttribute(3,0.5f), new SweepAttribute(true,1,2.5f)));

    //Axes
    public static final RegistryObject<Item> GOLDEN_BATTLE_AXE = ITEMS.register("golden_battle_axe",
            () -> new AdvancedAxeItem(Tiers.GOLD, 10, -3.4f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,1,3,0.05f,0.25f, 20,1,0.5f, Items.AIR));

    public static final RegistryObject<Item> GOLDEN_BATTLE_AXE_TWO_HANDED = ITEMS.register("golden_battle_axe_two_handed",
            () -> new TwoHandedIAxe(Tiers.GOLD, 10, -3.4f, new Item.Properties(),3.25,0, 0, 1,1,3,0.05f,0.25f, 20,1,0.5f, GOLDEN_BATTLE_AXE.get()));


    //Pole-Arms
    public static final RegistryObject<Item> GOLDEN_GLAIVE = ITEMS.register("golden_glaive",
            () -> new AdvancedSwordItem(Tiers.GOLD, 6, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none, new TwoHandedIIAttribute(4,0.5f), SweepAttribute.normal));

    public static final RegistryObject<Item> GOLDEN_SPEAR = ITEMS.register("golden_spear",
            () -> new AdvancedSwordItem(Tiers.GOLD, 2, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.2, new AttackAttribute(0,1,1,0,20,0,0), new TwoHandedAttribute(1,0,1,0.1f,0.55f), SweepAttribute.none, Items.AIR));

    public static final RegistryObject<Item> GOLDEN_SPEAR_TWO_HANDED = ITEMS.register("golden_spear_two_handed",
            () -> new TwoHandedIWeapon(Tiers.GOLD, 2, 1.3f, new Item.Properties(), 4.2, new AttackAttribute(0,1,1,0,20,0,0), new TwoHandedAttribute(1,0,1,0.1f,0.55f), SweepAttribute.none, GOLDEN_SPEAR.get()));

    public static final RegistryObject<Item> GOLDEN_HALBERD = ITEMS.register("golden_halberd",
            () -> new AdvancedSwordItem(Tiers.GOLD, 7, 0.7f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.5, new AttackAttribute(0,0.5f,4,0,20,1.5f,1), new TwoHandedIIAttribute(3,0.2f), SweepAttribute.none));

    public static final RegistryObject<Item> GOLDEN_PIKE = ITEMS.register("golden_pike",
            () -> new AdvancedSwordItem(Tiers.GOLD, 5, 0.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, new AttackAttribute(0,1,1,0,20,0,0),new TwoHandedIIAttribute(2,0.3f), SweepAttribute.none));





    //IRON
    //Bladed Weapons
    public static final RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger",
            () -> new AdvancedSwordItem(Tiers.IRON, 1, 3.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 1.8, new AttackAttribute(0,0,0,0,15,0,0), TwoHandedAttribute.none, new SweepAttribute(true, 1,0.25f)));

    public static final RegistryObject<Item> IRON_SHORTSWORD = ITEMS.register("iron_shortsword",
            () -> new AdvancedSwordItem(Tiers.IRON, 2, 2.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 2.25, AttackAttribute.none, TwoHandedAttribute.none, new SweepAttribute(true,1,0.75f)));

    public static final RegistryObject<Item> IRON_STILETTO = ITEMS.register("iron_stiletto",
            () -> new AdvancedSwordItem(Tiers.IRON, 1, 2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2, new AttackAttribute(0,0.25f,3,0,17,0,0), TwoHandedAttribute.none, SweepAttribute.none));

    public static final RegistryObject<Item> IRON_RAPIER = ITEMS.register("iron_rapier",
            () -> new AdvancedSwordItem(Tiers.IRON, 1, 2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3, new AttackAttribute(0,0,0,2,20,0,0), TwoHandedAttribute.none,SweepAttribute.normal));

    public static final RegistryObject<Item> IRON_KATANA = ITEMS.register("iron_katana",
            () -> new AdvancedSwordItem(Tiers.IRON, 3, 1.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,AttackAttribute.none,new TwoHandedAttribute(1,1,4,0.1f,1),new SweepAttribute(true,2,1.25f), Items.AIR));

    public static final RegistryObject<Item> IRON_KATANA_TWO_HANDED = ITEMS.register("iron_katana_two_handed",
            () -> new TwoHandedIWeapon(Tiers.IRON, 3, 1.8f, new Item.Properties(),3.25,AttackAttribute.none,new TwoHandedAttribute(1,1,4,0.1f,1),new SweepAttribute(true,2,1.25f), IRON_KATANA.get()));

    public static final RegistryObject<Item> IRON_GREATSWORD = ITEMS.register("iron_greatsword",
            () -> new AdvancedSwordItem(Tiers.IRON, 4, 1.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none,new TwoHandedIIAttribute(5,0.4f),new SweepAttribute(true, 4,1.5f)));

    public static final RegistryObject<Item> IRON_LONGSWORD = ITEMS.register("iron_longsword",
            () -> new AdvancedSwordItem(Tiers.IRON, 5, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(5,0.4f), new SweepAttribute(true, 1,2)));

    public static final RegistryObject<Item> IRON_TWINBLADE = ITEMS.register("iron_twinblade",
            () -> new AdvancedSwordItem(Tiers.IRON, 3, 1.9f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(5,0.4f),SweepAttribute.normal));

    public static final RegistryObject<Item> IRON_ZWEIHANDER = ITEMS.register("iron_zweihander",
            () -> new AdvancedSwordItem(Tiers.IRON, 4, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none,new TwoHandedIIAttribute(4,0.5f), new SweepAttribute(true,2,2.5f)));

    //Axes
    public static final RegistryObject<Item> IRON_BATTLE_AXE = ITEMS.register("iron_battle_axe",
            () -> new AdvancedAxeItem(Tiers.IRON, 11, -3.45f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,1,3,0.1f,0.25f, 20,1,0.5f, Items.AIR));

    public static final RegistryObject<Item> IRON_BATTLE_AXE_TWO_HANDED = ITEMS.register("iron_battle_axe_two_handed",
            () -> new TwoHandedIAxe(Tiers.IRON, 11, -3.45f, new Item.Properties(),3.25,0, 0, 1,1,3,0.1f,0.25f, 20,1,0.5f, IRON_BATTLE_AXE.get()));


    //Pole-Arms
    public static final RegistryObject<Item> IRON_GLAIVE = ITEMS.register("iron_glaive",
            () -> new AdvancedSwordItem(Tiers.IRON, 6, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none, new TwoHandedIIAttribute(4,0.5f), SweepAttribute.normal));

    public static final RegistryObject<Item> IRON_SPEAR = ITEMS.register("iron_spear",
            () -> new AdvancedSwordItem(Tiers.IRON, 2, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.2, new AttackAttribute(0,1,1,0,20,0,0), new TwoHandedAttribute(1,0,2,0.1f,0.55f), SweepAttribute.none, Items.AIR));

    public static final RegistryObject<Item> IRON_SPEAR_TWO_HANDED = ITEMS.register("iron_spear_two_handed",
            () -> new TwoHandedIWeapon(Tiers.IRON, 2, 1.3f, new Item.Properties(), 4.2, new AttackAttribute(0,1,1,0,20,0,0), new TwoHandedAttribute(1,0,2,0.1f,0.55f), SweepAttribute.none, IRON_SPEAR.get()));

    public static final RegistryObject<Item> IRON_HALBERD = ITEMS.register("iron_halberd",
            () -> new AdvancedSwordItem(Tiers.IRON, 7, 0.65f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.5, new AttackAttribute(0,0.5f,4,0,20,1.5f,1), new TwoHandedIIAttribute(3,0.2f), SweepAttribute.none));

    public static final RegistryObject<Item> IRON_PIKE = ITEMS.register("iron_pike",
            () -> new AdvancedSwordItem(Tiers.IRON, 4, 0.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, new AttackAttribute(0,1,2,0,20,0,0),new TwoHandedIIAttribute(3,0.3f), SweepAttribute.none));





    //DIAMOND
    //Bladed Weapons
    public static final RegistryObject<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 0, 3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 1.8, new AttackAttribute(0,0,0,0,15,0,0), TwoHandedAttribute.none, new SweepAttribute(true, 1,0.25f)));

    public static final RegistryObject<Item> DIAMOND_SHORTSWORD = ITEMS.register("diamond_shortsword",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 2, 2.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 2.25, AttackAttribute.none, TwoHandedAttribute.none, new SweepAttribute(true,1,0.75f)));

    public static final RegistryObject<Item> DIAMOND_STILETTO = ITEMS.register("diamond_stiletto",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 0, 2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2, new AttackAttribute(0,0.25f,4,0,17,0,0), TwoHandedAttribute.none, SweepAttribute.none));

    public static final RegistryObject<Item> DIAMOND_RAPIER = ITEMS.register("diamond_rapier",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 0, 2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3, new AttackAttribute(0,0,0,3,20,0,0), TwoHandedAttribute.none,SweepAttribute.normal));

    public static final RegistryObject<Item> DIAMOND_KATANA = ITEMS.register("diamond_katana",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 3, 1.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,AttackAttribute.none,new TwoHandedAttribute(1,2,5,0.05f,1),new SweepAttribute(true,2,1.25f), Items.AIR));

    public static final RegistryObject<Item> DIAMOND_KATANA_TWO_HANDED = ITEMS.register("diamond_katana_two_handed",
            () -> new TwoHandedIWeapon(Tiers.DIAMOND, 3, 1.8f, new Item.Properties(),3.25,AttackAttribute.none,new TwoHandedAttribute(1,2,5,0.05f,1),new SweepAttribute(true,2,1.25f), DIAMOND_KATANA.get()));

    public static final RegistryObject<Item> DIAMOND_GREATSWORD = ITEMS.register("diamond_greatsword",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 4, 1.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none,new TwoHandedIIAttribute(6,0.4f),new SweepAttribute(true, 5,1.5f)));

    public static final RegistryObject<Item> DIAMOND_LONGSWORD = ITEMS.register("diamond_longsword",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 5, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(6,0.4f), new SweepAttribute(true, 1,2)));

    public static final RegistryObject<Item> DIAMOND_TWINBLADE = ITEMS.register("diamond_twinblade",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 3, 1.9f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(6,0.4f),SweepAttribute.normal));

    public static final RegistryObject<Item> DIAMOND_ZWEIHANDER = ITEMS.register("diamond_zweihander",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 4, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none,new TwoHandedIIAttribute(5,0.5f), new SweepAttribute(true,2,2.5f)));

    //Axes
    public static final RegistryObject<Item> DIAMOND_BATTLE_AXE = ITEMS.register("diamond_battle_axe",
            () -> new AdvancedAxeItem(Tiers.DIAMOND, 11, -3.4f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,1,5,0.1f,0.25f, 20,1,0.5f, Items.AIR));

    public static final RegistryObject<Item> DIAMOND_BATTLE_AXE_TWO_HANDED = ITEMS.register("diamond_battle_axe_two_handed",
            () -> new TwoHandedIAxe(Tiers.DIAMOND, 11, -3.4f, new Item.Properties(),3.25,0, 0, 1,1,5,0.1f,0.25f, 20,1,0.5f, DIAMOND_BATTLE_AXE.get()));


    //Pole-Arms
    public static final RegistryObject<Item> DIAMOND_GLAIVE = ITEMS.register("diamond_glaive",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 6, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none, new TwoHandedIIAttribute(4,0.5f), SweepAttribute.normal));

    public static final RegistryObject<Item> DIAMOND_SPEAR = ITEMS.register("diamond_spear",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 1, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.2, new AttackAttribute(0,1,2,0,20,0,0), new TwoHandedAttribute(1,0,3,0.1f,0.55f), SweepAttribute.none, Items.AIR));

    public static final RegistryObject<Item> DIAMOND_SPEAR_TWO_HANDED = ITEMS.register("diamond_spear_two_handed",
            () -> new TwoHandedIWeapon(Tiers.DIAMOND, 1, 1.3f, new Item.Properties(), 4.2, new AttackAttribute(0,1,2,0,20,0,0), new TwoHandedAttribute(1,0,3,0.1f,0.55f), SweepAttribute.none, DIAMOND_SPEAR.get()));

    public static final RegistryObject<Item> DIAMOND_HALBERD = ITEMS.register("diamond_halberd",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 6, 0.7f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.5, new AttackAttribute(0,0.5f,4,0,20,1.5f,1), new TwoHandedIIAttribute(5,0.2f), SweepAttribute.none));

    public static final RegistryObject<Item> DIAMOND_PIKE = ITEMS.register("diamond_pike",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 4, 0.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, new AttackAttribute(0,1,2,0,20,0,0),new TwoHandedIIAttribute(4,0.3f), SweepAttribute.none));





    //NETHERITE
    //Bladed Weapons
    public static final RegistryObject<Item> NETHERITE_DAGGER = ITEMS.register("netherite_dagger",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 0, 3.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 1.8, new AttackAttribute(0,0,0,0,15,0,0), TwoHandedAttribute.none, new SweepAttribute(true, 1,0.25f)));

    public static final RegistryObject<Item> NETHERITE_SHORTSWORD = ITEMS.register("netherite_shortsword",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 2, 2.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 2.25, AttackAttribute.none, TwoHandedAttribute.none, new SweepAttribute(true,1,0.75f)));

    public static final RegistryObject<Item> NETHERITE_STILETTO = ITEMS.register("netherite_stiletto",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 0, 2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2, new AttackAttribute(0,0.25f,4,0,17,0,0), TwoHandedAttribute.none, SweepAttribute.none));

    public static final RegistryObject<Item> NETHERITE_RAPIER = ITEMS.register("netherite_rapier",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 0, 2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3, new AttackAttribute(0,0,0,3,20,0,0), TwoHandedAttribute.none,SweepAttribute.normal));

    public static final RegistryObject<Item> NETHERITE_KATANA = ITEMS.register("netherite_katana",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 3, 1.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,AttackAttribute.none,new TwoHandedAttribute(1,2,5,0.05f,1),new SweepAttribute(true,2,1.25f), Items.AIR));

    public static final RegistryObject<Item> NETHERITE_KATANA_TWO_HANDED = ITEMS.register("netherite_katana_two_handed",
            () -> new TwoHandedIWeapon(Tiers.NETHERITE, 3, 1.8f, new Item.Properties(),3.25,AttackAttribute.none,new TwoHandedAttribute(1,2,5,0.05f,1),new SweepAttribute(true,2,1.25f), NETHERITE_KATANA.get()));

    public static final RegistryObject<Item> NETHERITE_GREATSWORD = ITEMS.register("netherite_greatsword",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 4, 1.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none,new TwoHandedIIAttribute(6,0.4f),new SweepAttribute(true, 5,1.5f)));

    public static final RegistryObject<Item> NETHERITE_LONGSWORD = ITEMS.register("netherite_longsword",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 5, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(6,0.4f), new SweepAttribute(true, 1,2)));

    public static final RegistryObject<Item> NETHERITE_TWINBLADE = ITEMS.register("netherite_twinblade",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 3, 1.9f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(6,0.4f),SweepAttribute.normal));

    public static final RegistryObject<Item> NETHERITE_ZWEIHANDER = ITEMS.register("netherite_zweihander",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 4, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none,new TwoHandedIIAttribute(5,0.5f), new SweepAttribute(true,2,2.5f)));

    //Axes
    public static final RegistryObject<Item> NETHERITE_BATTLE_AXE = ITEMS.register("netherite_battle_axe",
            () -> new AdvancedAxeItem(Tiers.NETHERITE, 11, -3.4f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,1,5,0.1f,0.25f, 20,1,0.5f, Items.AIR));

    public static final RegistryObject<Item> NETHERITE_BATTLE_AXE_TWO_HANDED = ITEMS.register("netherite_battle_axe_two_handed",
            () -> new TwoHandedIAxe(Tiers.NETHERITE, 11, -3.4f, new Item.Properties(),3.25,0, 0, 1,1,5,0.1f,0.25f, 20,1,0.5f, NETHERITE_BATTLE_AXE.get()));


    //Pole-Arms
    public static final RegistryObject<Item> NETHERITE_GLAIVE = ITEMS.register("netherite_glaive",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 6, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none, new TwoHandedIIAttribute(4,0.5f), SweepAttribute.normal));

    public static final RegistryObject<Item> NETHERITE_SPEAR = ITEMS.register("netherite_spear",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 1, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.2, new AttackAttribute(0,1,2,0,20,0,0), new TwoHandedAttribute(1,0,3,0.1f,0.55f), SweepAttribute.none, Items.AIR));

    public static final RegistryObject<Item> NETHERITE_SPEAR_TWO_HANDED = ITEMS.register("netherite_spear_two_handed",
            () -> new TwoHandedIWeapon(Tiers.NETHERITE, 1, 1.3f, new Item.Properties(), 4.2, new AttackAttribute(0,1,2,0,20,0,0), new TwoHandedAttribute(1,0,3,0.1f,0.55f), SweepAttribute.none, NETHERITE_SPEAR.get()));

    public static final RegistryObject<Item> NETHERITE_HALBERD = ITEMS.register("netherite_halberd",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 6, 0.7f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.5, new AttackAttribute(0,0.5f,4,0,20,1.5f,1), new TwoHandedIIAttribute(5,0.2f), SweepAttribute.none));

    public static final RegistryObject<Item> NETHERITE_PIKE = ITEMS.register("netherite_pike",
            () -> new AdvancedSwordItem(Tiers.NETHERITE, 4, 0.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, new AttackAttribute(0,1,2,0,20,0,0),new TwoHandedIIAttribute(4,0.3f), SweepAttribute.none));














    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

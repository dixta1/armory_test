package net.dixta.dixtas_armory.item;

import net.dixta.dixtas_armory.DixtasArmory;
import net.dixta.dixtas_armory.item.custom.AdvancedAxeItem;
import net.dixta.dixtas_armory.item.custom.AdvancedSwordItem;
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
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 3, 1.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,AttackAttribute.none,new TwoHandedAttribute(1,2,5,0.05f,1),new SweepAttribute(true,2,1.25f)));

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
            () -> new AdvancedAxeItem(Tiers.DIAMOND, 11, -3.4f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,1,5,0.1f,0.25f, 20,1,0.5f));


    //Pole-Arms
    public static final RegistryObject<Item> DIAMOND_GLAIVE = ITEMS.register("diamond_glaive",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 6, 1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none, new TwoHandedIIAttribute(4,0.5f), SweepAttribute.normal));

    public static final RegistryObject<Item> DIAMOND_SPEAR = ITEMS.register("diamond_spear",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 1, 1.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.2, new AttackAttribute(0,1,2,0,20,0,0), new TwoHandedAttribute(1,0,3,0.1f,0.55f), SweepAttribute.none));

    public static final RegistryObject<Item> DIAMOND_HALBERD = ITEMS.register("diamond_halberd",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 6, 0.7f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.5, new AttackAttribute(0,0.5f,4,0,20,1.5f,1), new TwoHandedIIAttribute(5,0.2f), SweepAttribute.none));

    public static final RegistryObject<Item> DIAMOND_PIKE = ITEMS.register("diamond_pike",
            () -> new AdvancedSwordItem(Tiers.DIAMOND, 4, 0.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, new AttackAttribute(0,1,2,0,20,0,0),new TwoHandedIIAttribute(4,0.3f), SweepAttribute.none));













    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

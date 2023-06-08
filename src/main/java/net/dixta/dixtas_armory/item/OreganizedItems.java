package net.dixta.dixtas_armory.item;


//import galena.oreganized.index.OItemOItemTiers;
import galena.oreganized.index.OItemTiers;
import net.dixta.dixtas_armory.DixtasArmory;
import net.dixta.dixtas_armory.item.custom.AdvancedAxeItem;
import net.dixta.dixtas_armory.item.custom.AdvancedSwordItem;
import net.dixta.dixtas_armory.item.custom.attributes.AttackAttribute;
import net.dixta.dixtas_armory.item.custom.attributes.SweepAttribute;
import net.dixta.dixtas_armory.item.custom.attributes.TwoHandedAttribute;
import net.dixta.dixtas_armory.item.custom.attributes.TwoHandedIIAttribute;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OreganizedItems {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, DixtasArmory.MOD_ID);

    
    //ELECTRUM
    //Bladed Weapons

    public static final RegistryObject<Item> ELECTRUM_DAGGER = ITEMS.register("electrum_dagger",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 0, 4f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 1.8, new AttackAttribute(0,0,0,0,15,0,0), TwoHandedAttribute.none, new SweepAttribute(true, 1,0.25f)));

    public static final RegistryObject<Item> ELECTRUM_SHORTSWORD = ITEMS.register("electrum_shortsword",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 2, 2.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 2.25, AttackAttribute.none, TwoHandedAttribute.none, new SweepAttribute(true,1,0.75f)));

    public static final RegistryObject<Item> ELECTRUM_STILETTO = ITEMS.register("electrum_stiletto",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 0, 2.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),2, new AttackAttribute(0,0.25f,4,0,17,0,0), TwoHandedAttribute.none, SweepAttribute.none));

    public static final RegistryObject<Item> ELECTRUM_RAPIER = ITEMS.register("electrum_rapier",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 0, 2.3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3, new AttackAttribute(0,0,0,3,20,0,0), TwoHandedAttribute.none,SweepAttribute.normal));

    public static final RegistryObject<Item> ELECTRUM_KATANA = ITEMS.register("electrum_katana",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 3, 2, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,AttackAttribute.none,new TwoHandedAttribute(1,2,5,0.05f,1),new SweepAttribute(true,2,1.25f)));

    public static final RegistryObject<Item> ELECTRUM_GREATSWORD = ITEMS.register("electrum_greatsword",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 4, 1.4f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none,new TwoHandedIIAttribute(6,0.4f),new SweepAttribute(true, 5,1.5f)));

    public static final RegistryObject<Item> ELECTRUM_LONGSWORD = ITEMS.register("electrum_longsword",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 5, 1.4f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(6,0.4f), new SweepAttribute(true, 1,2)));

    public static final RegistryObject<Item> ELECTRUM_TWINBLADE = ITEMS.register("electrum_twinblade",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 3, 2.2f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.5,AttackAttribute.none, new TwoHandedIIAttribute(6,0.4f),SweepAttribute.normal));

    public static final RegistryObject<Item> ELECTRUM_ZWEIHANDER = ITEMS.register("electrum_zweihander",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 4, 1.1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none,new TwoHandedIIAttribute(5,0.5f), new SweepAttribute(true,2,2.5f)));

    //Axes
    public static final RegistryObject<Item> ELECTRUM_BATTLE_AXE = ITEMS.register("electrum_battle_axe",
            () -> new AdvancedAxeItem(OItemTiers.ELECTRUM, 11, -3.35f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),3.25,0, 0, 1,1,5,0.1f,0.25f, 20,1,0.5f, Items.AIR));


    //Pole-Arms
    public static final RegistryObject<Item> ELECTRUM_GLAIVE = ITEMS.register("electrum_glaive",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 6, 1.1f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB),  4, AttackAttribute.none, new TwoHandedIIAttribute(4,0.5f), SweepAttribute.normal));

    public static final RegistryObject<Item> ELECTRUM_SPEAR = ITEMS.register("electrum_spear",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 1, 1.5f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.2, new AttackAttribute(0,1,2,0,20,0,0), new TwoHandedAttribute(1,0,3,0.1f,0.55f), SweepAttribute.none));

    public static final RegistryObject<Item> ELECTRUM_HALBERD = ITEMS.register("electrum_halberd",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 6, 0.8f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 4.5, new AttackAttribute(0,0.5f,4,0,20,1.5f,1), new TwoHandedIIAttribute(5,0.2f), SweepAttribute.none));

    public static final RegistryObject<Item> ELECTRUM_PIKE = ITEMS.register("electrum_pike",
            () -> new AdvancedSwordItem(OItemTiers.ELECTRUM, 4, 0.9f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB), 5, new AttackAttribute(0,1,2,0,20,0,0),new TwoHandedIIAttribute(4,0.3f), SweepAttribute.none));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

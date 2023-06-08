package net.dixta.dixtas_armory;

import com.mojang.logging.LogUtils;

import net.dixta.dixtas_armory.item.ModItems;
import net.dixta.dixtas_armory.item.OreganizedItems;
import net.dixta.dixtas_armory.item.custom.AdvancedAxeItem;
import net.dixta.dixtas_armory.item.custom.AdvancedSwordItem;
import net.dixta.dixtas_armory.util.ModItemProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DixtasArmory.MOD_ID)
public class DixtasArmory
{
    public static final String MOD_ID = "dixtas_armory";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public DixtasArmory()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);

        if(ModList.get().isLoaded("oreganized"))
            OreganizedItems.register(eventBus);


        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        //MinecraftForge.EVENT_BUS.register(new RangedWeaponEffect());

    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        ((AdvancedSwordItem) ModItems.NETHERITE_KATANA.get()).pSwitchItem = ModItems.NETHERITE_KATANA_TWO_HANDED.get();
        ((AdvancedSwordItem) ModItems.DIAMOND_KATANA.get()).pSwitchItem = ModItems.DIAMOND_KATANA_TWO_HANDED.get();
        ((AdvancedSwordItem) ModItems.IRON_KATANA.get()).pSwitchItem = ModItems.IRON_KATANA_TWO_HANDED.get();
        ((AdvancedSwordItem) ModItems.STONE_KATANA.get()).pSwitchItem = ModItems.STONE_KATANA_TWO_HANDED.get();
        ((AdvancedSwordItem) ModItems.WOODEN_KATANA.get()).pSwitchItem = ModItems.WOODEN_KATANA_TWO_HANDED.get();
        ((AdvancedSwordItem) ModItems.GOLDEN_KATANA.get()).pSwitchItem = ModItems.GOLDEN_KATANA_TWO_HANDED.get();

        ((AdvancedSwordItem) ModItems.NETHERITE_SPEAR.get()).pSwitchItem = ModItems.NETHERITE_SPEAR_TWO_HANDED.get();
        ((AdvancedSwordItem) ModItems.DIAMOND_SPEAR.get()).pSwitchItem = ModItems.DIAMOND_SPEAR_TWO_HANDED.get();
        ((AdvancedSwordItem) ModItems.IRON_SPEAR.get()).pSwitchItem = ModItems.IRON_SPEAR_TWO_HANDED.get();
        ((AdvancedSwordItem) ModItems.STONE_SPEAR.get()).pSwitchItem = ModItems.STONE_SPEAR_TWO_HANDED.get();
        ((AdvancedSwordItem) ModItems.WOODEN_SPEAR.get()).pSwitchItem = ModItems.WOODEN_SPEAR_TWO_HANDED.get();
        ((AdvancedSwordItem) ModItems.GOLDEN_SPEAR.get()).pSwitchItem = ModItems.GOLDEN_SPEAR_TWO_HANDED.get();

        ((AdvancedAxeItem) ModItems.NETHERITE_BATTLE_AXE.get()).pSwitchItem = ModItems.NETHERITE_BATTLE_AXE_TWO_HANDED.get();
        ((AdvancedAxeItem) ModItems.DIAMOND_BATTLE_AXE.get()).pSwitchItem = ModItems.DIAMOND_BATTLE_AXE_TWO_HANDED.get();
        ((AdvancedAxeItem) ModItems.IRON_BATTLE_AXE.get()).pSwitchItem = ModItems.IRON_BATTLE_AXE_TWO_HANDED.get();
        ((AdvancedAxeItem) ModItems.STONE_BATTLE_AXE.get()).pSwitchItem = ModItems.STONE_BATTLE_AXE_TWO_HANDED.get();
        ((AdvancedAxeItem) ModItems.WOODEN_BATTLE_AXE.get()).pSwitchItem = ModItems.WOODEN_BATTLE_AXE_TWO_HANDED.get();
        ((AdvancedAxeItem) ModItems.GOLDEN_BATTLE_AXE.get()).pSwitchItem = ModItems.GOLDEN_BATTLE_AXE_TWO_HANDED.get();
    }
}

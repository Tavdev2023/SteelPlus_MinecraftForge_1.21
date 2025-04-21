package com.Excalibur.item;

import com.Excalibur.block.ModBlocks;
import com.Excalibur.steelplus.SteelPlus;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SteelPlus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STEELPLUS_ITEMS_TAB = CREATIVE_MODE_TABS.register("steelplus_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_CARBONITE.get()))
                    .title(Component.translatable("creativetab.steelplus.steelplus_items"))
                    .displayItems((itemDisplayParameter, output) -> {

                        output.accept(ModItems.RAW_CARBONITE.get());
                        output.accept(ModItems.CARBONITE_CORE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> STEELPLUS_TOOLS_TAB = CREATIVE_MODE_TABS.register("steelplus_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DARK_SWORD.get()))
                    .withTabsBefore(STEELPLUS_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.steelplus.steelplus_tools"))
                    .displayItems((itemDisplayParameter, output) -> {

                        output.accept(ModItems.DARK_SWORD.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> STEELPLUS_BLOCKS_TAB = CREATIVE_MODE_TABS.register("steelplus_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK.get()))
                    .withTabsBefore(STEELPLUS_TOOLS_TAB.getId())
                    .title(Component.translatable("creativetab.steelplus.steelplus_blocks"))
                    .displayItems((itemDisplayParameter, output) -> {

                        output.accept(ModBlocks.STEEL_BLOCK.get());
                        output.accept(ModBlocks.RAW_CARBONITE_BLOCK.get());
                        output.accept(ModBlocks.CARBONITE_ORE.get());
                        output.accept(ModBlocks.CARBONITE_DEEPSLATE_ORE.get());

                    }).build());

    public static void register (IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

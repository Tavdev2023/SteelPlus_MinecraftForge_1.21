package com.Excalibur.block;

import com.Excalibur.item.ModItems;
import com.Excalibur.steelplus.SteelPlus;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

//Basic setup for the mod blocks

public class ModBlocks {
    public static final DeferredRegister <Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SteelPlus.MOD_ID);

    // New Blocks here
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.ANVIL)));

    public static final RegistryObject<Block> RAW_CARBONITE_BLOCK = registerBlock("raw_carbonite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

package com.Excalibur.item;

import com.Excalibur.steelplus.SteelPlus;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SteelPlus.MOD_ID);


    public static final RegistryObject<Item> DARK_SWORD = ITEMS.register("darksword",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CARBONITE = ITEMS.register("raw_carbonite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARBONITE_CORE = ITEMS.register("carbonite_core",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}


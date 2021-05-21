package com.example.examplemod.setup;

import com.example.examplemod.common.blocks.ExampleBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.example.examplemod.ExampleMod.MODID;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        // ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<ExampleBlock> EXAMPLEBLOCK = BLOCKS.register("exampleblock", ExampleBlock::new);
    // public static final RegistryObject<Item> EXAMPLEBLOCK_ITEM = ITEMS.register("exampleblock", () -> new BlockItem(EXAMPLEBLOCK.get(), new Item.Properties().tab(ModSetup.ITEM_GROUP)));


}
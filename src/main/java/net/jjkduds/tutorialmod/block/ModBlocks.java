package net.jjkduds.tutorialmod.block;

import net.jjkduds.tutorialmod.JujutsuMod;
import net.jjkduds.tutorialmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

// so we are basically using the registerBlockItem method to registry an item that is associated to the block passed into its method, we need to do this cause when we register a new block with the deferred register
// actually it doesn't have an item associated to it, so you have to do it manually, that's when our helper method comes in


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, JujutsuMod.MOD_ID);

    public static final RegistryObject<Block> CursedIron_Ore = registerBlock("cursediron_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> RAW_CURSED_IRON_BLOCK = registerBlock("raw_cursed_iron_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).sound(SoundType.CANDLE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        //the first line registries the block
        //the second line registries the block item
        //then we return it
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return  toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

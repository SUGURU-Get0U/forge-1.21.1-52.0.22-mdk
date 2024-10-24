package net.jjkduds.tutorialmod.item;

import net.jjkduds.tutorialmod.JujutsuMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//this package holds every item that we will be creating
//a deferred register is basically a big list of things that wil contain our items
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JujutsuMod.MOD_ID);

    public static final RegistryObject<Item> Cursed_iron = ITEMS.register("cursediron",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Raw_cursed_ore = ITEMS.register("raw_cursed_ore",
    () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);


    }
}

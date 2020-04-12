package me.reconcubed.homeupdate.init;

import me.reconcubed.homeupdate.Homeupdate;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Homeupdate.MODID);

    public static final RegistryObject<Item> DEBUG_WAND = ITEMS.register("debug_wand", () -> new Item(new Item.Properties().group(ModItemGroups.HOME_UPDATE_GROUP)));
}

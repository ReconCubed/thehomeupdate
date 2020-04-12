package me.reconcubed.homeupdate.init;

import me.reconcubed.homeupdate.Homeupdate;
import me.reconcubed.homeupdate.block.CarpentersBenchBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Homeupdate.MODID);

    public static final RegistryObject<Block> CARPENTERS_BENCH = BLOCKS.register("carpenters_bench", () -> new CarpentersBenchBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 3.0F)));
}

package me.reconcubed.homeupdate.init;

import me.reconcubed.homeupdate.Homeupdate;
import me.reconcubed.homeupdate.tileentity.CarpentersBenchTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Homeupdate.MODID);

    public static final RegistryObject<TileEntityType<CarpentersBenchTileEntity>> CARPENTERS_BENCH = TILE_ENTITY_TYPES.register("carpenters_bench", () ->
            TileEntityType.Builder.create(CarpentersBenchTileEntity::new, ModBlocks.CARPENTERS_BENCH.get())
                    .build(null)
    );
}

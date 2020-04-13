package me.reconcubed.homeupdate.init;

import me.reconcubed.homeupdate.Homeupdate;
import me.reconcubed.homeupdate.container.CarpentersBenchContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Homeupdate.MODID);

    public static final RegistryObject<ContainerType<CarpentersBenchContainer>> CARPENTERS_BENCH = CONTAINER_TYPES.register("carpenters_bench", () -> IForgeContainerType.create(CarpentersBenchContainer::new));

}

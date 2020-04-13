package me.reconcubed.homeupdate.util;

import me.reconcubed.homeupdate.Homeupdate;
import me.reconcubed.homeupdate.client.gui.CarpentersBenchScreen;
import me.reconcubed.homeupdate.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Homeupdate.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ModContainerTypes.CARPENTERS_BENCH.get(), CarpentersBenchScreen::new);
    }
}

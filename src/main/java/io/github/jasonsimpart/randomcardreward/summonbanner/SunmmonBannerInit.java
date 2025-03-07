package io.github.jasonsimpart.randomcardreward.summonbanner;

import io.github.jasonsimpart.randomcardreward.RandomCardReward;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RandomCardReward.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SunmmonBannerInit
{

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        // ScreenManager.registerFactory(RandomCardReward.summen_banner_container.get(), SummonBannerScreen::new);
        event.enqueueWork(() -> MenuScreens.register(RandomCardReward.summen_banner_container.get(), SummonBannerScreen::new));

    }
}

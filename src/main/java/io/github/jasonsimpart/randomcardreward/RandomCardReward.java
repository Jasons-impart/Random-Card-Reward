package io.github.jasonsimpart.randomcardreward;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(RandomCardReward.MODID)
public class RandomCardReward {
    public static final String MODID = "randomcardreward";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RandomCardReward(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}

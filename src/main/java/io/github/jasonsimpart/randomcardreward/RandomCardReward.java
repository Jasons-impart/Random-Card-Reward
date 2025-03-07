package io.github.jasonsimpart.randomcardreward;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.logging.LogUtils;
import io.github.jasonsimpart.randomcardreward.commands.CommandInit;
import io.github.jasonsimpart.randomcardreward.gacha.AllGachas;
import io.github.jasonsimpart.randomcardreward.summonbanner.SummonBannerMenu;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(RandomCardReward.MODID)
public class RandomCardReward {
    public static final String MODID = "randomcardreward";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);

    public static final RegistryObject<MenuType<SummonBannerMenu>> summen_banner_container = MENU_TYPES.register("summon_banner", () -> IForgeMenuType.create((windowId, inventory, friendlyByteBuf) -> new SummonBannerMenu(windowId)));

    public RandomCardReward(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        register(modEventBus);
        init(modEventBus);
    }

    private void register(IEventBus modEventBus) {
        MENU_TYPES.register(modEventBus);
    }

    private void init(IEventBus modEventBus) {
        AllGachas.init();
    }

}

package io.github.jasonsimpart.randomcardreward.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.logging.LogUtils;
import io.github.jasonsimpart.randomcardreward.RandomCardReward;
import net.minecraft.commands.CommandSourceStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RandomCardReward.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommandInit {
    public static String baseCommand = "rcr";
    @SubscribeEvent
    public static void init(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        CommandsAllGacha.register(dispatcher);
        CommandSummonBanner.register(dispatcher);

        LogUtils.getLogger().info("Registered commands");

    }
}

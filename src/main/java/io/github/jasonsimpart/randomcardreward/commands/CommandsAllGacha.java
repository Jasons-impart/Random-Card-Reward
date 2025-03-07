package io.github.jasonsimpart.randomcardreward.commands;

import com.mojang.brigadier.CommandDispatcher;
import io.github.jasonsimpart.randomcardreward.gacha.AllGachas;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class CommandsAllGacha {
    // /rcr allGacha
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal(CommandInit.baseCommand)
            .then(Commands.literal("allGacha")
                .requires(r ->  r.hasPermission(2))
                .executes(context -> {
                    AllGachas.getGachas().forEach((k, v) -> {
                        context.getSource().sendSuccess(() -> Component.literal(String.format("id: %d, Cards: %d", k, v.getCardCount())), true);
                    });
                    return 1;
                })
            )
        );
    }
}

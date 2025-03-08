package io.github.jasonsimpart.randomcardreward.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.LongArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.jasonsimpart.randomcardreward.card.Card;
import io.github.jasonsimpart.randomcardreward.gacha.AllGachas;
import io.github.jasonsimpart.randomcardreward.gacha.Gacha;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class CommandUseCard {
    // /rcr useCard
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal(CommandInit.baseCommand)
            .then(Commands.literal("useCard")
                .requires(r ->  r.hasPermission(2))
                .then(Commands.argument("player", EntityArgument.player())
                    .then(Commands.argument("gachaId", LongArgumentType.longArg())
                        .suggests((context, builder) -> {
                            String input = builder.getRemaining();
                            AllGachas.getGachaIds().forEach(id -> {
                                if (String.valueOf(id).startsWith(input)) {
                                    builder.suggest(String.valueOf(id));
                                }
                            });
                            return builder.buildFuture();

                        })
                        .then(Commands.argument("cardId", LongArgumentType.longArg())
                            .executes(CommandUseCard::useCard)
                        )
                    )
                )
            )
        );

    }

    public static int useCard(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = EntityArgument.getPlayer(context, "player");
        long gachaId = LongArgumentType.getLong(context, "gachaId");
        long cardId = LongArgumentType.getLong(context, "cardId");

        Gacha gacha = AllGachas.getGacha(gachaId);
        if (gacha == null) {
            context.getSource().sendFailure(Component.literal("Gacha not found"));
            return 0;
        }

        Card card = gacha.getCard(cardId);
        if (card == null) {
            context.getSource().sendFailure(Component.literal("Card not found"));
            return 0;
        }

        card.use(player);
        return 1;
    }
}

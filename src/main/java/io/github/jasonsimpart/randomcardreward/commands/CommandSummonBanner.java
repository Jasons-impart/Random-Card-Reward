package io.github.jasonsimpart.randomcardreward.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import io.github.jasonsimpart.randomcardreward.gacha.AllGachas;
import io.github.jasonsimpart.randomcardreward.summonbanner.SummonBannerMenuProvider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkHooks;

import java.util.ArrayList;

public class CommandSummonBanner {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        // /rcr summonBanner
        dispatcher.register(Commands.literal(CommandInit.baseCommand)
                .then(Commands.literal("summonBanner")
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
                                        .executes(context -> {
                                            return summonBanner(EntityArgument.getPlayer(context, "player"), LongArgumentType.getLong(context, "gachaId"));
                                        })
                                        .then(Commands.argument("getCardCount", IntegerArgumentType.integer())
                                                .executes(context -> {
                                                    return summonBanner(EntityArgument.getPlayer(context, "player"), LongArgumentType.getLong(context, "gachaId"), IntegerArgumentType.getInteger(context, "getCardCount"));
                                                })
                                                .then(Commands.argument("bannerCount", IntegerArgumentType.integer())
                                                        .executes(context -> {
                                                            return summonBanner(EntityArgument.getPlayer(context, "player"), LongArgumentType.getLong(context, "gachaId"),IntegerArgumentType.getInteger(context, "getCardCount"), IntegerArgumentType.getInteger(context, "bannerCount"));
                                                        })
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private static int summonBanner(ServerPlayer player, long gachaId) {
        return summonBanner(player, gachaId, 1);

    }
    private static int summonBanner(ServerPlayer player, long gachaId, int cardCount) {
        return summonBanner(player, gachaId, cardCount, 10);

    }
    private static int summonBanner(ServerPlayer player, long gachaId, int cardCount, int bannerCount) {
        NetworkHooks.openScreen(player, new SummonBannerMenuProvider());
        return 1;
    }
}

package io.github.jasonsimpart.randomcardreward.summonbanner;

import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SummonBannerMenuProvider implements MenuProvider {
    @Override
    public @NotNull Component getDisplayName() {
        return Component.literal("Summon Banner");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SummonBannerMenu(i);
    }
}

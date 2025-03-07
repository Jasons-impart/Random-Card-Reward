package io.github.jasonsimpart.randomcardreward.summonbanner;

import io.github.jasonsimpart.randomcardreward.RandomCardReward;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SummonBannerMenu extends AbstractContainerMenu {
    public SummonBannerMenu(int pContainerId) {
        super(RandomCardReward.summen_banner_container.get(), pContainerId);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}

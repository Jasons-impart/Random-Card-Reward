package io.github.jasonsimpart.randomcardreward.summonbanner;

import io.github.jasonsimpart.randomcardreward.RandomCardReward;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SummonBannerScreen extends AbstractContainerScreen<SummonBannerMenu> {
    public static final ResourceLocation GUI = new ResourceLocation(RandomCardReward.MODID, "textures/gui/summon_banner.png");

    public SummonBannerScreen(SummonBannerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.inventoryLabelY = -1000;
        this.imageWidth = this.imageWidth + 100;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        guiGraphics.blit(GUI, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }
}

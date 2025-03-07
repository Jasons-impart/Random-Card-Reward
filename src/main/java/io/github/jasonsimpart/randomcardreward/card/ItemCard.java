package io.github.jasonsimpart.randomcardreward.card;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ItemCard extends Card {
    ItemStack itemStack;
    public ItemCard() {
        super();
    }

    public ItemCard(long id, ItemStack itemStack) {
        super(id);
        this.itemStack = itemStack;
    }

    @Override
    public void use(Player player) {
        if(itemStack != null) {
            player.getInventory().add(itemStack);
        }
    }
}

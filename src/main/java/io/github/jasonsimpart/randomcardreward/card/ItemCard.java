package io.github.jasonsimpart.randomcardreward.card;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

@Deprecated(since = "beta", forRemoval = true)
public class ItemCard extends Card {
    ItemStack itemStack;
    public ItemCard() {
        super();
    }

    public static Card readFromJson(JsonElement element) {
        return null;
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

package io.github.jasonsimpart.randomcardreward.card;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.world.entity.player.Player;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Card {
    long id;
    public Card() {
        this.id = ThreadLocalRandom.current().nextLong();
    }

    public Card(long id) {
        this.id = id;
    }

    public abstract void use(Player player);

    public long getId() {
        return id;
    }
}

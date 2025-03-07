package io.github.jasonsimpart.randomcardreward.card;

import net.minecraft.world.entity.player.Player;

import java.util.concurrent.ThreadLocalRandom;

public class Card {
    long id;
    public Card() {
        this.id = ThreadLocalRandom.current().nextLong();
    }

    public Card(long id) {
        this.id = id;
    }

    public void use(Player player) {

    }

    public long getId() {
        return id;
    }
}

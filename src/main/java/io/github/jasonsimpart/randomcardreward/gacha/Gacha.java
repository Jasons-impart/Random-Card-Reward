package io.github.jasonsimpart.randomcardreward.gacha;

import io.github.jasonsimpart.randomcardreward.card.Card;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Gacha {
    long id;
    Map<Long, Card> cards = new java.util.HashMap<>();

    public Gacha() {
        this.id = ThreadLocalRandom.current().nextLong();
    }

    public Gacha(long id) {
        this.id = id;
    }

    public Gacha(Map<Long, Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.put(card.getId(), card);
    }

    public long getId() {
        return id;
    }

    public int getCardCount() {
        return cards.size();
    }
}

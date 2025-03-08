package io.github.jasonsimpart.randomcardreward.gacha;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.jasonsimpart.randomcardreward.card.Card;
import io.github.jasonsimpart.randomcardreward.card.CommandCard;

import java.util.List;
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

    public static Gacha readFromJson(JsonElement element) {
        JsonObject obj = element.getAsJsonObject();
        JsonElement id = obj.get("id");
        Gacha gacha;
        if (id != null) {
            gacha = new Gacha(id.getAsLong());
        } else {
            gacha = new Gacha();
        }
        JsonArray cards = obj.get("cards").getAsJsonArray();
        for (JsonElement card : cards) {
            var cardObj = card.getAsJsonObject();
            var type = cardObj.get("type").getAsString();
            if(type.equals("command"))
            {
                Card c = CommandCard.readFromJson(card);
                if (c != null) {
                    gacha.addCard(c);
                }
            }
        }
        return gacha;
    }

    public void addCard(Card card) {
        cards.put(card.getId(), card);
    }

    public long getId() {
        return id;
    }

    public Card getCard(long id) {
        return cards.get(id);
    }

    public List<Long>  getCardIds() {
        return new java.util.ArrayList<>(cards.keySet());
    }

    public int getCardCount() {
        return cards.size();
    }
}

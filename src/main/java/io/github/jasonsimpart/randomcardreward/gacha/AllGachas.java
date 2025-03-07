package io.github.jasonsimpart.randomcardreward.gacha;

import io.github.jasonsimpart.randomcardreward.card.ItemCard;
import net.minecraft.world.item.Items;

import java.util.Map;

public class AllGachas {
    static Map<Long, Gacha> gachas = new java.util.HashMap<>();

    public static void addGacha(Gacha gacha) {
        gachas.put(gacha.getId(), gacha);
    }

    public static Gacha getGacha(long id) {
        return gachas.get(id);
    }

    public static Map<Long, Gacha> getGachas() {
        return gachas;
    }

    public static void init(){
        ItemCard card = new ItemCard(1, Items.APPLE.getDefaultInstance());
        Gacha gacha = new Gacha();
        gacha.addCard(card);
        addGacha(gacha);

        ItemCard card2 = new ItemCard(3, Items.APPLE.getDefaultInstance());
        ItemCard card3 = new ItemCard(6, Items.APPLE.getDefaultInstance());
        Gacha gacha2 = new Gacha();
        gacha2.addCard(card2);
        gacha2.addCard(card3);
        addGacha(gacha2);
    }
}

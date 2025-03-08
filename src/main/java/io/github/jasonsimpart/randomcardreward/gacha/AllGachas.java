package io.github.jasonsimpart.randomcardreward.gacha;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.github.jasonsimpart.randomcardreward.RandomCardReward;
import io.github.jasonsimpart.randomcardreward.card.CommandCard;
import io.github.jasonsimpart.randomcardreward.card.ItemCard;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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

    public static List<Long> getGachaIds() {
        return new ArrayList<>(gachas.keySet());
    }

    public static void init(){
        gachas.clear();

        test();


        try {
            Path configPath = FMLPaths.CONFIGDIR.get().resolve(RandomCardReward.MODID).resolve("gacha");

            if (!configPath.toFile().exists()) {
                configPath.toFile().mkdirs();
            }

            for (var file : configPath.toFile().listFiles()) {
                if (file.getName().endsWith(".json")) {
                    String json = Files.readString(file.toPath());
                    JsonElement element = JsonParser.parseString(json);
                    var gacha = Gacha.readFromJson(element);

                    if (gacha != null) {
                        addGacha(gacha);
                    }


                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void test() {
        ItemCard card = new ItemCard(1, Items.APPLE.getDefaultInstance());
        Gacha gacha = new Gacha(1111);
        gacha.addCard(card);
        addGacha(gacha);

        CommandCard card2 = new CommandCard(2, "/say man! what can i say?");
        ItemCard card3 = new ItemCard(6, Items.APPLE.getDefaultInstance());
        Gacha gacha2 = new Gacha(111);
        gacha2.addCard(card2);
        gacha2.addCard(card3);
        addGacha(gacha2);

        Gacha gacha3 = new Gacha(331211);
        addGacha(gacha3);
    }
}

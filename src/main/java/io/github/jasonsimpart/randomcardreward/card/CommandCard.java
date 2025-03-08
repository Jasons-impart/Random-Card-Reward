package io.github.jasonsimpart.randomcardreward.card;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.List;

public class CommandCard extends Card {
    String command;
    public CommandCard() {
        super();
    }

    public static Card readFromJson(JsonElement element) {
        JsonObject obj = element.getAsJsonObject();
        JsonElement id = obj.get("id");
        JsonElement commandElement = obj.get("command");
        if (id != null && commandElement != null) {
            String command = "";
            if (commandElement.isJsonArray()) {
                JsonArray commandArray = commandElement.getAsJsonArray();
                List<String> commands = new java.util.ArrayList<>();
                for (JsonElement commandElement1 : commandArray) {
                    commands.add(commandElement1.getAsString());
                }
                command = String.format(commands.get(0), commands.subList(1, commands.size()).toArray());
            } else if (commandElement.isJsonPrimitive()) {
                command = commandElement.getAsString();
            }else  {
                return null;
            }
            if(!command.startsWith("/")) {
                command = "/" + command;
            }

            return new CommandCard(id.getAsLong(), command);
        }
        return null;
    }

    public CommandCard(long id, String command) {
        super(id);
        this.command = command;
    }

    @Override
    public void use(Player player) {
        if(command != null) {
            var server = ServerLifecycleHooks.getCurrentServer();
            var source = new CommandSourceStack(CommandSource.NULL, Vec3.ZERO, Vec2.ZERO, server.overworld(), 4, "RCR", Component.literal("RCR"), server, null);
            server.getCommands().performPrefixedCommand(source, command);
        }
    }
}

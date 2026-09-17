package dev.jab125.touchscreenenhancements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import dev.jab125.touchscreenenhancements.config.TouchScreenEnhancementsVoile;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TouchScreenEnhancements implements ModInitializer {
    public static TouchScreenEnhancementsVoile CONFIG = new TouchScreenEnhancementsVoile(true, true, true);

    public static TouchScreenEnhancementsVoile getConfig() {
        return CONFIG;
    }

    public static void setConfig(TouchScreenEnhancementsVoile newConfig) {
        CONFIG = newConfig;
    }

    @Override
    public void onInitialize() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("touchscreenenhancements.json");
        if (Files.exists(configPath)) {
            try {
                String s = Files.readString(configPath);
                CONFIG = TouchScreenEnhancementsVoile.CODEC.parse(JsonOps.INSTANCE, new Gson().fromJson(s, JsonElement.class)).getOrThrow();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ClientLifecycleEvents.CLIENT_STOPPING.register(m -> {
            try {
                Files.writeString(configPath, new GsonBuilder().setPrettyPrinting().create().toJson(
                        TouchScreenEnhancementsVoile.CODEC.encodeStart(JsonOps.INSTANCE, CONFIG).getOrThrow()
                ));
            } catch (IOException e) {
                System.err.println("failed to save config");
            }
        });
    }
}

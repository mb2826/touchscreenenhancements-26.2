package dev.jab125.touchscreenenhancements.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class TouchScreenEnhancementsVoile {
    public static final Codec<TouchScreenEnhancementsVoile> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.BOOL.fieldOf("enabled").forGetter(TouchScreenEnhancementsVoile::enabled),
                    Codec.BOOL.fieldOf("clickable_hotbar").forGetter(TouchScreenEnhancementsVoile::clickableHotbar),
                    Codec.BOOL.fieldOf("clickable_crosshair").forGetter(TouchScreenEnhancementsVoile::clickableCrosshair)
            ).apply(instance, TouchScreenEnhancementsVoile::new)
    );

    public boolean enabled;
    public boolean clickableHotbar;
    public boolean clickableCrosshair;

    public TouchScreenEnhancementsVoile(boolean enabled, boolean clickableHotbar, boolean clickableCrosshair) {
        this.enabled = enabled;
        this.clickableHotbar = clickableHotbar;
        this.clickableCrosshair = clickableCrosshair;
    }

    public boolean enabled() {
        return this.enabled;
    }

    public boolean clickableHotbar() {
        return this.clickableHotbar;
    }

    public boolean clickableCrosshair() {
        return this.clickableCrosshair;
    }
}

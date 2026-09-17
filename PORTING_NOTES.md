# Porting Notes for Minecraft 26.2

Original mod targeted Minecraft 1.21.10 (obfuscated / intermediate names).

Minecraft 26.2+ is unobfuscated (official Mojang names). The mixin targets and many method/field references from the original decompiled sources therefore need updating to official names.

## Key original classes (intermediary)
- `net.minecraft.class_312` → MouseHandler
- `net.minecraft.class_310` → Minecraft
- `net.minecraft.class_329` → Gui
- `net.minecraft.class_1041` → Window
- Mouse button / event classes also changed between versions

## What is already done in this repo
- fabric.mod.json depends on ~26.2
- Gradle + Loom 1.17 setup for 26.2
- Config system (TouchScreenEnhancementsVoile + JSON save/load)
- Entry points and ModMenu stub
- Language file

## What still needs completing
1. Rewrite the four client mixins (`GuiMixin`, `MinecraftMixin`, `MouseHandlerMixin`, `KeyMappingMixin`) against official 26.2 names.
2. Port `GuiGuiEventListener` (the overlay that handles hotbar + crosshair taps).
3. Port the config screen.
4. Test on a real 26.2 client with touch / Steam Deck input.

The original 1.0.0 jar (for 1.21.10) is kept in the artifacts zip for reference.

Original sources: https://github.com/Jab125/touchscreenenhancements

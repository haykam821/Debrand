package io.github.haykam821.debrand.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.*;

@Config(name = "debrand")
@Config.Gui.Background("minecraft:textures/block/orange_wool.png")
public class ModConfig implements ConfigData {
	@ConfigEntry.Category("modded")
	@ConfigEntry.Gui.TransitiveObject
	public ModdedIndicationConfig modded = new ModdedIndicationConfig();

	public static class ModdedIndicationConfig {
		@ConfigEntry.Gui.Tooltip
		public boolean windowTitle = false;

		@ConfigEntry.Gui.Tooltip
		public boolean titleScreen = false;
	}
}

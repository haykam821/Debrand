package io.github.haykam821.debrand;

import io.github.haykam821.debrand.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
	public static ModConfig CONFIG = AutoConfig.register(ModConfig.class, GsonConfigSerializer::new).getConfig();

	@Override
	public void onInitialize() {
		return;
	}
}
package io.github.haykam821.debrand.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.debrand.config.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;

import org.spongepowered.asm.mixin.injection.At;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;isModded()Z"))
	public boolean isModded(MinecraftClient client) {
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		if (!config.modded.titleScreen) return false;
		return client.isModded();
	}
}
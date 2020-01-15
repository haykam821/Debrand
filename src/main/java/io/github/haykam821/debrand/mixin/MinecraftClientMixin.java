package io.github.haykam821.debrand.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.debrand.config.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;

import org.spongepowered.asm.mixin.injection.At;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Redirect(method = "method_24287", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;method_24289()Z"))
	public boolean method_24289(MinecraftClient client) {
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

		if (!config.modded.windowTitle) return false;
		return client.method_24289();
	}
}
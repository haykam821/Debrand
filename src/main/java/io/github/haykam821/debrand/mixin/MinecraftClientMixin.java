package io.github.haykam821.debrand.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.debrand.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.ModStatus;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Redirect(method = "getWindowTitle", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/ModStatus;isModded()Z"))
	public boolean isModded(ModStatus modStatus) {
		if (!Main.CONFIG.modded.windowTitle) return false;
		return modStatus.isModded();
	}
}
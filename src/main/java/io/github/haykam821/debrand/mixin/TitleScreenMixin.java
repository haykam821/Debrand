package io.github.haykam821.debrand.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.debrand.Main;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.util.ModStatus;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/ModStatus;isModded()Z"))
	public boolean isModded(ModStatus modStatus) {
		if (!Main.CONFIG.modded.titleScreen) return false;
		return modStatus.isModded();
	}
}
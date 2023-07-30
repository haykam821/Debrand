package io.github.haykam821.debrand.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.debrand.Main;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.util.ModStatus;

@SuppressWarnings("target")
@Mixin(TitleScreen.class)
public class MatrixStackTitleScreenMixin {
	@Redirect(method = "method_25394(Lnet/minecraft/class_4587;IIF)V", remap = false, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_6683;method_39029()Z"))
	public boolean isModded(ModStatus modStatus) {
		if (!Main.CONFIG.modded.titleScreen) return false;
		return modStatus.isModded();
	}
}
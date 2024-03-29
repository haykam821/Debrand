package io.github.haykam821.debrand.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.debrand.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;

@SuppressWarnings("target")
@Mixin(TitleScreen.class)
public class OldTitleScreenMixin {
	@Redirect(method = "method_25394(Lnet/minecraft/class_4587;IIF)V", remap = false, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_310;method_24289()Z"))
	public boolean isModded(MinecraftClient client) {
		if (!Main.CONFIG.modded.titleScreen) return false;
		return ((OldMinecraftClientAccessor) (Object) client).isModded();
	}
}
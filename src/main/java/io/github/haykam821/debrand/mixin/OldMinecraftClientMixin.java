package io.github.haykam821.debrand.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.debrand.Main;
import net.minecraft.client.MinecraftClient;

@Mixin(MinecraftClient.class)
public abstract class OldMinecraftClientMixin {
	@Redirect(method = "getWindowTitle", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_310;method_24289()Z", remap = false))
	public boolean isModded(MinecraftClient client) {
		if (!Main.CONFIG.modded.windowTitle) return false;
		return ((OldMinecraftClientAccessor) (Object) client).isModded();
	}
}
package io.github.haykam821.strippedbranding.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MinecraftClient.class)
class MinecraftClientMixin {
	public boolean method_24289() {
		return false;
	}
}
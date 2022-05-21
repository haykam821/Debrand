package io.github.haykam821.debrand.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.gen.Invoker;

@Pseudo
@Mixin(targets = "net.minecraft.class_310", remap = false)
public interface OldMinecraftClientAccessor {
	@Invoker("method_24289")
	public boolean isModded();
}
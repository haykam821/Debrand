package io.github.haykam821.debrand.mixin;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.SemanticVersion;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;
import net.fabricmc.loader.api.metadata.version.VersionPredicate;

public class DebrandMixinConfigPlugin implements IMixinConfigPlugin {
	public static final boolean HAS_MOD_STATUS = isMinecraftVersion(">=1.18-alpha.21.41.a");
	public static final boolean HAS_DRAW_CONTEXT = isMinecraftVersion(">=1.20-alpha.23.16.a");

	private static final String OLD_CLIENT_ACCESSOR_CLASS = "io.github.haykam821.debrand.mixin.OldMinecraftClientAccessor";
	private static final String OLD_CLIENT_CLASS = "io.github.haykam821.debrand.mixin.OldMinecraftClientMixin";
	private static final String OLD_TITLE_SCREEN_CLASS = "io.github.haykam821.debrand.mixin.OldTitleScreenMixin";

	private static final String MATRIX_STACK_TITLE_SCREEN_CLASS = "io.github.haykam821.debrand.mixin.MatrixStackTitleScreenMixin";

	private static final String NEW_CLIENT_CLASS = "io.github.haykam821.debrand.mixin.MinecraftClientMixin";
	private static final String NEW_TITLE_SCREEN_CLASS = "io.github.haykam821.debrand.mixin.TitleScreenMixin";

	@Override
	public void onLoad(String mixinPackage) {
		return;
	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClass, String mixinClass) {
		if (mixinClass.equals(OLD_CLIENT_ACCESSOR_CLASS) || mixinClass.equals(OLD_CLIENT_CLASS) || mixinClass.equals(OLD_TITLE_SCREEN_CLASS)) {
			return !HAS_MOD_STATUS;
		} else if (mixinClass.equals(MATRIX_STACK_TITLE_SCREEN_CLASS)) {
			return HAS_MOD_STATUS && !HAS_DRAW_CONTEXT;
		} else if (mixinClass.equals(NEW_CLIENT_CLASS)) {
			return HAS_MOD_STATUS;
		} else if (mixinClass.equals(NEW_TITLE_SCREEN_CLASS)) {
			return HAS_MOD_STATUS && HAS_DRAW_CONTEXT;
		}

		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
		return;
	}

	@Override
	public List<String> getMixins() {
		return null;
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		return;
	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		return;
	}

	private static Version getMinecraftVersion() {
		Optional<ModContainer> container = FabricLoader.getInstance().getModContainer("minecraft");

		if (container.isPresent()) {
			Version version = container.get().getMetadata().getVersion();
			if (version instanceof SemanticVersion) {
				return version;
			}
		}

		return null;
	}

	private static boolean isMinecraftVersion(String versionRange) {
		try {
			Predicate<Version> predicate = VersionPredicate.parse(versionRange);
			return predicate.test(getMinecraftVersion());
		} catch (VersionParsingException exception) {
			return false;
		}
	}
}
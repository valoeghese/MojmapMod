package tk.valoeghese.mojmapmod.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

@Mixin(Item.class)
public class MixinItem {
	@Shadow
	@Final
	private static Random random;

	@Unique
	private CreativeModeTab randomTabCache;

	@Overwrite
	public final CreativeModeTab getItemCategory() {
		if (this.randomTabCache == null) {
			this.randomTabCache = CreativeModeTab.field_7921[random.nextInt(CreativeModeTab.field_7921.length)];
		}

		return this.randomTabCache;
	}
}

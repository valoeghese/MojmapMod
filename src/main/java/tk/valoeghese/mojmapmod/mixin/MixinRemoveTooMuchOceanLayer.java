package tk.valoeghese.mojmapmod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.RemoveTooMuchOceanLayer;

@Mixin(value = RemoveTooMuchOceanLayer.class, priority = 500)
public class MixinRemoveTooMuchOceanLayer {
	
	@Inject(at = @At("HEAD"), method = "sample", cancellable = true)
	private void sample(Context context, int int_1, int int_2, int int_3, int int_4, int centreBiome, CallbackInfoReturnable<Integer> info) {
		info.setReturnValue(moddedIsOcean(centreBiome) && moddedIsOcean(int_1) && moddedIsOcean(int_2) && moddedIsOcean(int_4) && moddedIsOcean(int_3) && context.nextRandom(3) >= 0 ? 1 : centreBiome);
	}

	@Unique
	private static boolean moddedIsOcean(int biome) {
		return Registry.BIOME.byId(biome).getBiomeCategory() == Biome.BiomeCategory.OCEAN;
	}
	
}


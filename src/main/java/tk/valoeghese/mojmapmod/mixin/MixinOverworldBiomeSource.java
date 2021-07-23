package tk.valoeghese.mojmapmod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.OverworldBiomeSource;

@Mixin(OverworldBiomeSource.class)
public class MixinOverworldBiomeSource {
	@Overwrite
	public Biome getNoiseBiome(int genX, int j, int genZ) {
		return getClimaticBiome(genX << 2, genZ << 2);
	}

	@Unique
	private Biome getClimaticBiome(int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}
}

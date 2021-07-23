package tk.valoeghese.mojmapmod.climate;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public final class Climate {
	Climate(BiomeCategory category, Precipitation precipitation, float temperature, float humidity, SurfaceBuilderBaseConfiguration configuration) {
		this.biome = new ClimateBiome(category, precipitation, temperature, humidity, configuration);
	}

	private final Biome biome;

	public Biome getBiome() {
		return this.biome;
	}

	public static float[] getTemperatureHumidity(Latitude latitude, float rainfall) {
		final float contribution = rainfall * 0.1f;

		switch (latitude) {
		case POLAR:
			return new float[] {0.5f * contribution + 0.05f, contribution + 0.1f}; //       0 - 0.1  |  0 - 0.2
		case BOREAL:
			return new float[] {contribution + 0.2f, 0, 2 * contribution + 0.3f}; //      0.1 - 0.3  |  0.1 - 0.5
		case SUBTROPICAL:
			return new float[] {contribution + 0.8f, 0, 4 * contribution + 0.5f}; //      0.7 - 0.9  |  0.1 - 0.9
		case TROPICAL:
			return new float[] {0.5f * contribution + 0.95f, 5 * contribution + 0.5f}; // 0.9 - 1.0  |  0.0 - 1.0
		case TEMPERATE:
			return new float[] {2 * contribution + 0.5f, 3 * contribution + 0.4f}; //     0.3 - 0.7  |  0.1 - 0.7
		default:
			throw new RuntimeException("Invalid latitude zone used in climate calculation!");
		}
	}
}

class ClimateBiome extends Biome {
	ClimateBiome(BiomeCategory category, Precipitation precipitation, float temperature, float humidity, SurfaceBuilderBaseConfiguration configuration) {
		super(new BiomeBuilder()
				.biomeCategory(category)
				.depth(0.3F)
				.downfall(temperature)
				.parent(null)
				.precipitation(precipitation)
				.scale(0.25F)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, configuration));
	}
}
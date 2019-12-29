package tk.valoeghese.mojmapmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class MojmapMod implements ModInitializer {
	public static final Logger log = LogManager.getLogger("MojmapMod");

	@Override
	public void onInitialize() {
		log.info("ARR");
	}

}

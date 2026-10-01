package fr.mathyslefebvre.frenchkitchen;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrenchKitchen implements ModInitializer {
    public static final String MOD_ID = "french-kitchen";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModItems.init();
        LOGGER.info("French Kitchen charge !");
    }
}

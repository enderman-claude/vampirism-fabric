package de.teamlapen.vampirism;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * M0 scaffold entrypoint. Unofficial Fabric port of Vampirism; original by TeamLapen.
 * Contains no mod content yet.
 */
public class VampirismFabric implements ModInitializer {

    private static final Logger LOGGER = LogManager.getLogger("vampirism-fabric");

    @Override
    public void onInitialize() {
        LOGGER.info("Vampirism Fabric port (unofficial, 0% migrated) loaded: scaffold only.");
    }
}

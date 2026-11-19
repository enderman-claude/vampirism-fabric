package de.teamlapen.vampirism;

import de.teamlapen.vampirism.registry.VampirismItems;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Unofficial Fabric port of Vampirism; original by TeamLapen.
 * Build commit is only shown when CI injected it (see build.gradle); local builds omit it.
 */
public class VampirismFabric implements ModInitializer {

    private static final Logger LOGGER = LogManager.getLogger("vampirism-fabric");
    private static final String BUILD_INFO = "/vampirism-build.properties";

    @Override
    public void onInitialize() {
        VampirismItems.init();
        LOGGER.info("Vampirism Fabric port (unofficial, ~6% migrated, not yet fully launched) loaded.");
        String commit = readBuildCommit();
        if (commit != null) {
            LOGGER.info("Build commit: {}", commit);
        }
    }

    private static String readBuildCommit() {
        try (InputStream in = VampirismFabric.class.getResourceAsStream(BUILD_INFO)) {
            if (in == null) {
                return null;
            }
            Properties props = new Properties();
            props.load(in);
            String commit = props.getProperty("commit");
            return (commit == null || commit.isEmpty()) ? null : commit;
        } catch (IOException e) {
            return null;
        }
    }
}

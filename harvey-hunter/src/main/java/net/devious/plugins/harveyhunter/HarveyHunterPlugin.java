package net.devious.plugins.harveyhunter;

import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.Getter;
import net.devious.plugins.harveyhunter.tasks.CheckInventory;
import net.devious.plugins.harveyhunter.tasks.CheckTraps;
import net.devious.plugins.harveyhunter.tasks.Loot;
import net.devious.plugins.harveyhunter.tasks.PlaceTraps;
import net.runelite.api.Client;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.hunter.HunterTrap;
import net.unethicalite.api.plugins.Task;
import net.unethicalite.api.plugins.TaskPlugin;
import org.pf4j.Extension;

import java.util.HashMap;
import java.util.Map;

@Extension
@PluginDescriptor(
        name = "Harvey Hunter",
        enabledByDefault = false
)

public class HarveyHunterPlugin extends TaskPlugin
{
    private final Task[] tasks =
            {
                    new CheckInventory(this),
                    new PlaceTraps(this),
                    new CheckTraps(this),
                    new Loot(this)
            };

    @Override
    public Task[] getTasks()
    {
        return tasks;
    }

    @Getter
    protected final Map<WorldPoint, HunterTrap> traps = new HashMap<>();

    @Inject
    @Getter
    private Client client;

    @Inject
    @Getter
    private HunterConfig config;

    @Provides
    HunterConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(HunterConfig.class);
    }
}

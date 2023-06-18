package net.devious.plugins.harveyhunter;

import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.Getter;
import lombok.Setter;
import net.devious.plugins.harveyhunter.strategies.salamander.SwampLizardInventoryStrategy;
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

import java.util.concurrent.ConcurrentHashMap;

@Extension
@PluginDescriptor(
        name = "Harvey Hunter",
        enabledByDefault = false
)

public class hHunterPlugin extends TaskPlugin
{
    private final Task[] tasks =
            {
                    new CheckInventory(this, new SwampLizardInventoryStrategy(this)),
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
    protected final ConcurrentHashMap<WorldPoint, HunterTrap> traps = new ConcurrentHashMap<>();

    @Getter
    @Setter
    protected WorldPoint centerTile;

    @Inject
    @Getter
    private Client client;

    @Inject
    @Getter
    private hHunterConfig config;

    @Provides
    hHunterConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(hHunterConfig.class);
    }
}

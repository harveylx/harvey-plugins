package net.devious.plugins.animated;

import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.Getter;
import net.devious.plugins.animated.tasks.ActivateAnimator;
import net.devious.plugins.animated.tasks.CheckInventory;
import net.devious.plugins.animated.tasks.Eat;
import net.devious.plugins.animated.tasks.Loot;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Task;
import net.unethicalite.api.plugins.TaskPlugin;
import org.pf4j.Extension;

@Extension
@PluginDescriptor(
        name = "Harvey Animated Armour",
        enabledByDefault = false
)
public class AnimatedArmourPlugin extends TaskPlugin
{
    private final Task[] tasks =
            {
                    new CheckInventory(this),
                    new Eat(this),
                    new ActivateAnimator(this),
                    new Loot(this)
            };


    @Inject
    @Getter
    private Client client;

    @Inject
    @Getter
    private AnimatedArmourConfig config;

    @Provides
    AnimatedArmourConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(AnimatedArmourConfig.class);
    }

    @Override
    public Task[] getTasks()
    {
        return tasks;
    }
}

package net.devious.plugins.sandworm;

import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.Getter;
import net.devious.plugins.sandworm.tasks.Sandworm;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Task;
import net.unethicalite.api.plugins.TaskPlugin;
import org.pf4j.Extension;

@Extension
@PluginDescriptor(
		name = "Harvey Sandworm",
		enabledByDefault = false
)
public class SandwormPlugin extends TaskPlugin
{
	private final Task[] tasks =
			{
					new Sandworm(this)
			};

	@Inject
	@Getter
	private SandwormConfig config;

	@Inject
	@Getter
	private Client client;

	@Override
	public Task[] getTasks()
	{
		return tasks;
	}

	@SuppressWarnings("unused")
	@Provides
    SandwormConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SandwormConfig.class);
	}
}

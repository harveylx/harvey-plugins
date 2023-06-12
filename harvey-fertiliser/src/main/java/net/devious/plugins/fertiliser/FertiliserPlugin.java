package net.devious.plugins.fertiliser;

import com.google.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Task;
import net.unethicalite.api.plugins.TaskPlugin;
import org.pf4j.Extension;

@Extension
@PluginDescriptor(
		name = "Harvey Sandworm",
		enabledByDefault = false
)
public class FertiliserPlugin extends TaskPlugin
{
	private final Task[] tasks =
			{

			};

	@Inject
	@Getter
	private Client client;

	@Override
	public Task[] getTasks()
	{
		return tasks;
	}
}

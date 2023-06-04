package net.devious.plugins.dynamite;

import com.google.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Task;
import net.unethicalite.api.plugins.TaskPlugin;
import org.pf4j.Extension;

@Extension
@PluginDescriptor(
		name = "Harvey Dynamite",
		enabledByDefault = false
)
public class DynamitePlugin extends TaskPlugin
{
	private final Task[] tasks =
			{
					new Dynamite(this)
			};

	@Getter
	@Setter
	public boolean goToShop = false;

	@Inject
	@Getter
	private Client client;

	@Override
	public Task[] getTasks()
	{
		return tasks;
	}
}

package net.devious.plugins.sandworm;

import com.google.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.devious.plugins.sandworm.tasks.BuyBuckets;
import net.devious.plugins.sandworm.tasks.CheckInventory;
import net.devious.plugins.sandworm.tasks.Dig;
import net.devious.plugins.sandworm.tasks.GoToShop;
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
public class SandwormPlugin extends TaskPlugin
{
	private final Task[] tasks =
			{
					new CheckInventory(this),
					new GoToShop(this),
					new BuyBuckets(this),
					new Dig(this)
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

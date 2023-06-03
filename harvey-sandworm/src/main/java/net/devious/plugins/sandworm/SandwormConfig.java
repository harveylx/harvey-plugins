package net.devious.plugins.sandworm;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("harveysandworm")
public interface SandwormConfig extends Config
{
	@ConfigItem(
			keyName = "item",
			name = "Item",
			description = ""
	)
	default Worm item()
	{
		return Worm.SANDWORM;
	}
}

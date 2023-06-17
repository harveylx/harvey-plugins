package net.devious.plugins.harveyhunter;

import net.devious.plugins.harveyhunter.enums.HunterType;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("harveyhunter")
public interface HunterConfig extends Config
{
    @ConfigSection(
            name = "Hunter type",
            description = "Hunter settings",
            position = 0
    )
    String hunter = "HarveyHunter";

    @ConfigItem(
            keyName = "hunterType",
            name = "Hunter type",
            description = "Type of animal to catch",
            position = 1,
            section = hunter
    )
    default HunterType hunterType()
    {
        return HunterType.SwampLizard;
    }

    @ConfigItem(
            position = 2,
            keyName = "releaseAnimals",
            name = "Release",
            description = "Release animals after capturing",
            section = hunter
    )
    default boolean release()
    {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "numberOfTraps",
            name = "Number of traps",
            description = "Number of traps to set",
            section = hunter
    )
    default int maxTraps()
    {
        return 2;
    }
}

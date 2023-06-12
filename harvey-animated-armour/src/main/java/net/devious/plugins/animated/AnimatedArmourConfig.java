package net.devious.plugins.animated;

import net.devious.plugins.animated.enums.ArmourType;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("harveyanimated")
public interface AnimatedArmourConfig extends Config
{
    @ConfigSection(
            name = "Armour Type",
            description = "Armour settings",
            position = 991,
            closedByDefault = true
    )
    String armour = "Armour";

    @ConfigItem(
            keyName = "armourType",
            name = "Armour type",
            description = "Type of armour to use and fight against",
            position = 1,
            section = armour
    )
    default ArmourType armourType()
    {
        return ArmourType.Bronze;
    }
}

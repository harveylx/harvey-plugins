package net.devious.plugins.animated.tasks;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.animated.AnimatedArmourConfig;
import net.devious.plugins.animated.AnimatedArmourContext;
import net.devious.plugins.animated.AnimatedArmourPlugin;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.items.Inventory;

@Slf4j
public class CheckInventory extends AnimatedArmourContext
{
    public CheckInventory(AnimatedArmourPlugin context)
    {
        super(context);
    }

    @Override
    public boolean validate()
    {
        return !Players.getLocal().isInteracting() && Players.getLocal().isIdle();
    }

    @Override
    public boolean isBlocking()
    {
        return false;
    }

    @Override
    public int execute()
    {
        AnimatedArmourConfig config = getConfig();
        if (!Inventory.contains(config.armourType().getHelm(), config.armourType().getPlatelegs(), config.armourType().getPlatebody()))
        {
            log.info("Missing armour pieces, check config and make sure you have all required pieces");
            return -1;
        }
        return -3;
    }
}

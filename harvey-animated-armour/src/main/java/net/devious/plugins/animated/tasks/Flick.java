package net.devious.plugins.animated.tasks;

import net.devious.plugins.animated.AnimatedArmourContext;
import net.devious.plugins.animated.AnimatedArmourPlugin;
import net.unethicalite.api.entities.Players;

public class Flick extends AnimatedArmourContext
{
    public Flick(AnimatedArmourPlugin context)
    {
        super(context);
    }

    @Override
    public boolean validate()
    {
        return Players.getLocal().isInteracting();
    }

    @Override
    public boolean isBlocking()
    {
        return false;
    }

    @Override
    public int execute()
    {
        return 0;
    }
}

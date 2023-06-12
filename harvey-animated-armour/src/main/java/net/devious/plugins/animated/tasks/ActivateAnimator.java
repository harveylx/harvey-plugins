package net.devious.plugins.animated.tasks;

import net.devious.plugins.animated.AnimatedArmourConfig;
import net.devious.plugins.animated.AnimatedArmourContext;
import net.devious.plugins.animated.AnimatedArmourPlugin;
import net.runelite.api.ObjectID;
import net.runelite.api.TileObject;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.items.Inventory;

public class ActivateAnimator extends AnimatedArmourContext
{

    public ActivateAnimator(AnimatedArmourPlugin context)
    {
        super(context);
    }

    @Override
    public boolean validate()
    {
        AnimatedArmourConfig config = getConfig();
        return !Players.getLocal().isInteracting() && Inventory.contains(config.armourType().getHelm(), config.armourType().getPlatelegs(), config.armourType().getPlatebody());
    }

    @Override
    public boolean isBlocking()
    {
        return false;
    }

    @Override
    public int execute()
    {
        TileObject animate = TileObjects.getFirstSurrounding(Players.getLocal().getWorldLocation(), 10, ObjectID.MAGICAL_ANIMATOR);
        if (animate != null)
        {
            animate.interact("Magical Animator", "Animate");
        }

        return 1000;
    }
}

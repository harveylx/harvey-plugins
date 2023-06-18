package net.devious.plugins.harveyhunter.tasks;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.harveyhunter.hHunterPlugin;
import net.devious.plugins.harveyhunter.hHunterContext;
import net.runelite.api.TileObject;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;

@Slf4j
public class PlaceTraps extends hHunterContext
{
    public PlaceTraps(hHunterPlugin context)
    {
        super(context);
    }

    @Override
    public boolean validate()
    {
        return !Players.getLocal().isAnimating()
                && !Players.getLocal().isInteracting()
                && !Players.getLocal().isMoving()
                && Players.getLocal().isIdle();
    }

    @Override
    public boolean isBlocking()
    {
        return false;
    }

    @Override
    public int execute()
    {
        if (getTraps().size() < getConfig().maxTraps())
        {
            TileObject trapObject = TileObjects.getFirstSurrounding(getCenterTile(), 3, getConfig().hunterType().getTrapObjectIds());
            if (trapObject != null)
            {
                trapObject.interact("Young Tree", "Set-trap");
                Time.sleepTicks(4);
            }
        }
        return -3;
    }
}

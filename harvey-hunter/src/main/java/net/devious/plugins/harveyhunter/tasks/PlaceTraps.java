package net.devious.plugins.harveyhunter.tasks;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.harveyhunter.HarveyHunterPlugin;
import net.devious.plugins.harveyhunter.HunterContext;
import net.runelite.api.Player;
import net.runelite.api.TileObject;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;

@Slf4j
public class PlaceTraps extends HunterContext
{
    public PlaceTraps(HarveyHunterPlugin context)
    {
        super(context);
    }

    @Override
    public boolean validate()
    {
        return true;
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
            Player local = Players.getLocal();

            if (getCenterTile() == null)
            {
                setCenterTile(local.getWorldLocation());
            }

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

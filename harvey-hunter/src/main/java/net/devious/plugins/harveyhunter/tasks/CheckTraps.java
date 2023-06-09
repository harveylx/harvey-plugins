package net.devious.plugins.harveyhunter.tasks;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.harveyhunter.hHunterPlugin;
import net.devious.plugins.harveyhunter.hHunterContext;
import net.runelite.api.GameObject;
import net.runelite.api.ObjectID;
import net.runelite.api.TileObject;
import net.runelite.api.coords.Angle;
import net.runelite.api.coords.Direction;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.hunter.HunterTrap;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;

import java.util.Iterator;
import java.util.Map;

@Slf4j
public class CheckTraps extends hHunterContext
{
    public CheckTraps(hHunterPlugin context)
    {
        super(context);
    }

    @Override
    public boolean validate()
    {
        return getTraps().size() > 0
                && !Players.getLocal().isAnimating()
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
    public boolean subscribe()
    {
        return true;
    }

    @Override
    public int execute()
    {
        Iterator<Map.Entry<WorldPoint, HunterTrap>> iterator = getTraps().entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<WorldPoint, HunterTrap> entry = iterator.next();
            HunterTrap trap = entry.getValue();

            if (trap.getState() == HunterTrap.State.FULL)
            {
                TileObject trapObject = TileObjects.getFirstSurrounding(getCenterTile(), 5,
                        getConfig().hunterType().getCaughtTrapObjectIds());

                if (trapObject != null)
                {
                    trapObject.interact(getConfig().hunterType().getInteractText());
                    Time.sleepTicks(4);
                    iterator.remove();
                }
            }
        }
        return -3;
    }

    @Subscribe
    public void onGameObjectSpawned(GameObjectSpawned event)
    {
        final GameObject gameObject = event.getGameObject();
        final WorldPoint trapLocation = gameObject.getWorldLocation();
        final HunterTrap myTrap = getTraps().get(trapLocation);

        if (gameObject.getId() == ObjectID.NET_TRAP_9343)
        {
            // Net traps facing to the north and east must have their tile translated.
            // As otherwise, the wrong tile is stored.
            Direction trapOrientation = new Angle(gameObject.getOrientation()).getNearestDirection();
            WorldPoint translatedTrapLocation = trapLocation;

            switch (trapOrientation)
            {
                case SOUTH:
                    translatedTrapLocation = trapLocation.dy(-1);
                    break;
                case WEST:
                    translatedTrapLocation = trapLocation.dx(-1);
                    break;
            }
            getTraps().put(translatedTrapLocation, new HunterTrap(gameObject));
        }

        if (gameObject.getId() == ObjectID.NET_TRAP_9004)
        {
            if (myTrap != null)
            {
                myTrap.setState(HunterTrap.State.FULL);
            }
        }

        if (gameObject.getId() == ObjectID.YOUNG_TREE_9341)
        {
            getTraps().remove(trapLocation);
        }
    }
}

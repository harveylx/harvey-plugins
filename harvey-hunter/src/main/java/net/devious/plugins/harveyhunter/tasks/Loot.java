package net.devious.plugins.harveyhunter.tasks;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.harveyhunter.hHunterPlugin;
import net.devious.plugins.harveyhunter.hHunterContext;
import net.runelite.api.ItemID;
import net.runelite.api.TileItem;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileItems;

import java.util.List;

@Slf4j
public class Loot extends hHunterContext
{
    public Loot(hHunterPlugin context)
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
        List<TileItem> loot = TileItems.getSurrounding(getCenterTile(), 10, getConfig().hunterType().getTrapItemIds());
        return loot.size() != 0;
    }

    @Override
    public int execute()
    {
        List<TileItem> loot = TileItems.getSurrounding(getCenterTile(), 10, ItemID.ROPE, ItemID.SMALL_FISHING_NET);
        if (loot.size() != 0)
        {
            loot.forEach(i ->
            {
                i.pickup();
                Time.sleepTicks(3);
            });
        }
        return -3;
    }
}

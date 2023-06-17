package net.devious.plugins.harveyhunter.tasks;

import net.devious.plugins.harveyhunter.HarveyHunterPlugin;
import net.devious.plugins.harveyhunter.HunterContext;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.TileItem;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileItems;

import java.util.List;

public class Loot extends HunterContext
{
    public Loot(HarveyHunterPlugin context)
    {
        super(context);
    }

    @Override
    public boolean validate()
    {
        return true;
    }

    @Override
    public int execute()
    {
        Player local = Players.getLocal();

        List<TileItem> loot = TileItems.getSurrounding(local.getWorldLocation(), 10, ItemID.ROPE, ItemID.SMALL_FISHING_NET);
        if (loot.size() != 0)
        {
            loot.forEach(TileItem::pickup);
        }
        return -3;
    }

    @Override
    public boolean isBlocking()
    {
        return false;
    }
}

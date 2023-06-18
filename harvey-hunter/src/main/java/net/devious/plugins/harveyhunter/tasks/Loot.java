package net.devious.plugins.harveyhunter.tasks;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.harveyhunter.HarveyHunterPlugin;
import net.devious.plugins.harveyhunter.HunterContext;
import net.runelite.api.ItemID;
import net.runelite.api.TileItem;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.entities.TileItems;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
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
        List<TileItem> loot = TileItems.getSurrounding(getCenterTile(), 10, ItemID.ROPE, ItemID.SMALL_FISHING_NET);
        if (loot.size() != 0)
        {
            log.info("Size of the loot table is {}", loot.size());
            AtomicInteger loopCount = new AtomicInteger();
            loot.forEach(i ->
            {
                log.info(String.valueOf(loopCount.incrementAndGet()));
                i.pickup();
                Time.sleepTicks(3);
            });
        }
        return -3;
    }
}

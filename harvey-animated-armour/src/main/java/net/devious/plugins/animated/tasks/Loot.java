package net.devious.plugins.animated.tasks;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.animated.AnimatedArmourContext;
import net.devious.plugins.animated.AnimatedArmourPlugin;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.TileItem;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileItems;

import java.util.List;

@Slf4j
public class Loot extends AnimatedArmourContext
{
    public Loot(AnimatedArmourPlugin context)
    {
        super(context);
    }

    @Override
    public boolean validate()
    {
        return !Players.getLocal().isInteracting() && !Players.getLocal().isAnimating() && Players.getLocal().isIdle();
    }

    @Override
    public boolean isBlocking()
    {
        return false;
    }

    @Override
    public int execute()
    {
        Player local = Players.getLocal();

        List<TileItem> loot = TileItems.getSurrounding(local.getWorldLocation(), 10, getConfig().armourType().getHelm(),
                getConfig().armourType().getPlatebody(), getConfig().armourType().getPlatelegs(), ItemID.WARRIOR_GUILD_TOKEN);

        loot.forEach(TileItem::pickup);

        return -1;
    }
}

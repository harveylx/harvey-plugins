package net.devious.plugins.harveyhunter.tasks;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.harveyhunter.Strategy;
import net.devious.plugins.harveyhunter.hHunterContext;
import net.devious.plugins.harveyhunter.hHunterPlugin;
import net.unethicalite.api.entities.Players;

@Slf4j
public class CheckInventory extends hHunterContext
{
    Strategy strategy;

    public CheckInventory(hHunterPlugin context, Strategy strategy)
    {
        super(context);
        this.strategy = strategy;
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
        if (getCenterTile() == null)
        {
            setCenterTile(Players.getLocal().getWorldLocation());
        }
        return strategy.execute();
    }
}

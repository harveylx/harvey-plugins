package net.devious.plugins.harveyhunter.tasks;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.harveyhunter.HunterConfig;
import net.devious.plugins.harveyhunter.HunterContext;
import net.devious.plugins.harveyhunter.HarveyHunterPlugin;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.items.Inventory;

@Slf4j
public class CheckInventory extends HunterContext
{
    private boolean blockNext = false;

    public CheckInventory(HarveyHunterPlugin context)
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
        return blockNext;
    }

    @Override
    public int execute()
    {
        HunterConfig config = getConfig();
        CheckForTrapsInInventory(config);

        if (config.release())
        {
            ReleaseAnimals(config);
        }
        return -3;
    }

    private static void ReleaseAnimals(HunterConfig config)
    {
        if (Inventory.contains(config.hunterType().getInventoryAnimalId()))
        {
            Inventory.getAll(config.hunterType().getInventoryAnimalId()).forEach(i ->
            {
                i.interact(x -> x != null && (x.toLowerCase().contains("release")));
                Time.sleep(400);
            });
        }
    }

    private void CheckForTrapsInInventory(HunterConfig config)
    {
        if (!Inventory.contains(config.hunterType().getTrapIds()))
        {
            log.info("Traps for selected config {} not found", config.hunterType().toString());
            blockNext = true;
        }
    }
}

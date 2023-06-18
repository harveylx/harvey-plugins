package net.devious.plugins.harveyhunter.strategies.salamander;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.harveyhunter.Strategy;
import net.devious.plugins.harveyhunter.hHunterConfig;
import net.devious.plugins.harveyhunter.hHunterPlugin;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.items.Inventory;

@Slf4j
public class SwampLizardInventoryStrategy implements Strategy
{
    hHunterPlugin context;

    public SwampLizardInventoryStrategy(hHunterPlugin context)
    {
        this.context = context;
    }

    @Override
    public int execute()
    {
        CheckForTrapsInInventory(context.getConfig());

        if (context.getConfig().release())
        {
            ReleaseAnimals(context.getConfig());
        }
        return -3;
    }

    private static void ReleaseAnimals(hHunterConfig config)
    {
        if (Inventory.contains(config.hunterType().getInventoryNpcId()))
        {
            Inventory.getAll(config.hunterType().getInventoryNpcId()).forEach(i ->
            {
                i.interact(x -> x != null && (x.toLowerCase().contains("release")));
                Time.sleep(400);
            });
        }
    }

    private void CheckForTrapsInInventory(hHunterConfig config)
    {
        if (!Inventory.contains(config.hunterType().getTrapItemIds()))
        {
            log.info("Traps for selected config {} not found", config.hunterType().toString());
        }
    }
}

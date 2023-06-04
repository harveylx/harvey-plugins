package net.devious.plugins.sandworm.tasks;

import net.devious.plugins.sandworm.SandwormContext;
import net.devious.plugins.sandworm.SandwormPlugin;
import net.runelite.api.ItemID;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.items.Inventory;

public class CheckInventory extends SandwormContext
{
    public CheckInventory(SandwormPlugin context)
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
        if (isGoToShop())
            return -1;

        if (!Inventory.isFull() && !Inventory.contains(ItemID.BUCKET))
        {
            setGoToShop(true);
            return -1;
        }

        if (Inventory.isFull() && Inventory.contains(ItemID.BUCKET_OF_SAND))
        {
            Inventory.getAll(ItemID.BUCKET_OF_SAND).forEach(i -> {
                i.interact(x -> x != null && (x.toLowerCase().contains("empty")));
                Time.sleep(400);
            });
            return -3;
        }
        return 1000;
    }
}

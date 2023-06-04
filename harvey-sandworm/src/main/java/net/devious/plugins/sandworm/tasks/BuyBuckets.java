package net.devious.plugins.sandworm.tasks;

import net.devious.plugins.sandworm.SandwormContext;
import net.devious.plugins.sandworm.SandwormPlugin;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.entities.NPCs;
import net.unethicalite.api.items.Shop;
import net.unethicalite.api.movement.Movement;

public class BuyBuckets extends SandwormContext
{
    public BuyBuckets(SandwormPlugin context)
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
        if (Movement.isWalking())
            return -1;

		if (isGoToShop())
        {
            NPC shop = NPCs.getNearest("Tynan");
            // We talk to the npc first to hand in all sandworms
            shop.interact("Talk-to");
            Time.sleep(2000);
            shop.interact("Trade");
            Time.sleep(2000);

            if (Shop.isOpen())
            {
                Shop.buyFifty(ItemID.BUCKET);
                Time.sleep(3000);

                Movement.walkTo(1843, 3805, 0);
                setGoToShop(false);
            }
        }
        return -1;
    }
}

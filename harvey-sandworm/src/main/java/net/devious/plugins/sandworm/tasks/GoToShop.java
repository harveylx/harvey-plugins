package net.devious.plugins.sandworm.tasks;

import net.devious.plugins.sandworm.SandwormContext;
import net.devious.plugins.sandworm.SandwormPlugin;
import net.runelite.api.NPC;
import net.unethicalite.api.entities.NPCs;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;

public class GoToShop extends SandwormContext
{
    public GoToShop(SandwormPlugin context)
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

        System.out.println("we here");
        if (Movement.isWalking())
            return -1;

        if (isGoToShop())
        {
            NPC shop = NPCs.getNearest("Tynan");
            if (shop == null || !Reachable.isInteractable(shop))
            {
                Movement.walkTo(1843, 3787, 0);
                return -1;
            }
            return -3;
        }

        return 1000;
    }
}

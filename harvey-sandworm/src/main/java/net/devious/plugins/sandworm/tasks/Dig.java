package net.devious.plugins.sandworm.tasks;

import net.devious.plugins.sandworm.SandwormContext;
import net.devious.plugins.sandworm.SandwormPlugin;
import net.runelite.api.ObjectID;
import net.runelite.api.Player;
import net.runelite.api.TileObject;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.movement.Movement;

public class Dig extends SandwormContext
{
	public Dig(SandwormPlugin context)
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
		Player local = Players.getLocal();

		if (Movement.isWalking())
			return -1;

		if (isGoToShop())
			return -1;

		TileObject dig = TileObjects.getFirstSurrounding(local.getWorldLocation(), 10, ObjectID.SANDWORM_CASTINGS);
		if (dig != null)
		{
			dig.interact("Sandworm castings", "Dig");
			return -9;
		}

		return 1000;
	}

	@Override
	public boolean subscribe()
	{
		return true;
	}
}

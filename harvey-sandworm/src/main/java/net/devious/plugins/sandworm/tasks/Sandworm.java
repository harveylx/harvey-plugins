package net.devious.plugins.sandworm.tasks;

import net.runelite.api.*;
import net.runelite.client.chat.ChatColorType;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.entities.NPCs;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.items.Shop;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;
import net.unethicalite.api.utils.MessageUtils;
import net.devious.plugins.sandworm.SandwormPlugin;
import net.devious.plugins.sandworm.Worm;

public class Sandworm extends SandwormTask
{
	public Sandworm(SandwormPlugin context)
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
		Worm worm = getConfig().item();
		Player local = Players.getLocal();

		if (Movement.isWalking())
		{
			return -1;
		}

		if (Inventory.isFull() && Inventory.contains(ItemID.BUCKET_OF_SAND))
		{
			Inventory.getAll(ItemID.BUCKET_OF_SAND).forEach(i -> {
				i.interact(x -> x != null && (x.toLowerCase().contains("empty")));
				Time.sleep(250);
			});
			return -3;
		}

		if (Inventory.isFull() && !Inventory.contains(ItemID.BUCKET_OF_SAND) && !Inventory.contains(ItemID.BUCKET))
		{
			NPC shop = NPCs.getNearest("Tynan");
			if (shop == null || !Reachable.isInteractable(shop))
			{
				Movement.walkTo(1843, 3787, 0);
				return -3;
			}
			shop.interact("Talk-to");
			Time.sleep(1000);
			shop.interact("Trade");
			return -3;
		}

		if (Shop.isOpen())
		{
			Shop.buyFifty(ItemID.BUCKET);
			Time.sleep(1000);
			Movement.walkTo(1843, 3805, 0);
			return -1;
		}

		TileObject dig = TileObjects.getFirstSurrounding(local.getWorldLocation(), 10, worm.getGroundId());
		if (dig != null)
		{
			dig.interact("Sandworm castings", "Dig");
			return -3;
		}

		MessageUtils.addMessage("Digging for sandworm.", ChatColorType.NORMAL);

		return 1000;
	}

	@Override
	public boolean subscribe()
	{
		return true;
	}
}

package net.devious.plugins.dynamite;

import net.runelite.api.NPC;
import net.runelite.api.widgets.WidgetInfo;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.entities.NPCs;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.widgets.Widgets;

public class Dynamite extends DynamiteContext
{
    public Dynamite(DynamitePlugin context)
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
        if (Bank.isOpen())
        {
            Bank.depositInventory();
//            Bank.withdraw(13570, 9, Bank.WithdrawMode.ITEM);
//            Bank.withdraw(1931, 9, Bank.WithdrawMode.ITEM);
//            Bank.withdraw(13421, 9, Bank.WithdrawMode.ITEM);
//            Bank.withdraw(13571, 9, Bank.WithdrawMode.ITEM);
            Bank.withdraw(1759, 14, Bank.WithdrawMode.ITEM);
            Bank.withdraw(13572, 14, Bank.WithdrawMode.ITEM);
            Widgets.get(WidgetInfo.BANK_CONTAINER.getGroupId(), 2, 11).interact(0);
            Time.sleep(1000);
        }
        if (!Inventory.contains(item -> item.getId() == 13572))
        {
            NPC banker = NPCs.getNearest("Banker");
            banker.interact("Bank");
        }
        return -3;
    }
}

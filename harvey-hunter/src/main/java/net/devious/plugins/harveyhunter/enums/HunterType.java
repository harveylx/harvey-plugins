package net.devious.plugins.harveyhunter.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.*;

@RequiredArgsConstructor
@Getter
public enum HunterType
{
    SwampLizard(NpcID.SWAMP_LIZARD,
            ItemID.SWAMP_LIZARD,
            TrapObjectID.YOUNG_TREE,
            CaughtTrapObjectID.NET_TRAPS,
            TrapItemID.NET_TRAPS,
            "Check");

    private final int npcId;
    private final int inventoryNpcId;
    private final int[] trapObjectIds;
    private final int[] caughtTrapObjectIds;
    private final int[] trapItemIds;
    private final String interactText;
}

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
            TrapItemID.NET_TRAPS);

    private final int animalId;
    private final int inventoryAnimalId;
    private final int[] trapObjectIds;
    private final int[] trapIds;
}

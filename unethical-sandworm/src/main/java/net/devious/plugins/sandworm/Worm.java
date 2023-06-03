package net.devious.plugins.sandworm;

import lombok.Getter;
import net.runelite.api.ObjectID;

@Getter
public enum Worm
{
	SANDWORM(ObjectID.SANDWORM_CASTINGS),
	;
	private final int groundId;

	Worm(int groundId)
	{
		this.groundId = groundId;
	}
}

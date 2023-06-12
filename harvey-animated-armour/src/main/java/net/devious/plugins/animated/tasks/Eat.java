package net.devious.plugins.animated.tasks;

import lombok.extern.slf4j.Slf4j;
import net.devious.plugins.animated.AnimatedArmourContext;
import net.devious.plugins.animated.AnimatedArmourPlugin;
import net.runelite.api.Skill;

@Slf4j
public class Eat extends AnimatedArmourContext
{

    public Eat(AnimatedArmourPlugin context)
    {
        super(context);
    }

    @Override
    public boolean validate()
    {
        return getClient().getBoostedSkillLevel(Skill.HITPOINTS) <= 70;
    }

    @Override
    public boolean isBlocking()
    {
        return false;
    }

    @Override
    public int execute()
    {
        return -1;
    }
}

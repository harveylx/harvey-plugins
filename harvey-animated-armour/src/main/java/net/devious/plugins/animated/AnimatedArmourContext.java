package net.devious.plugins.animated;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import net.unethicalite.api.plugins.Task;

@RequiredArgsConstructor
public abstract class AnimatedArmourContext implements Task
{
    @Delegate
    public final AnimatedArmourPlugin context;
}

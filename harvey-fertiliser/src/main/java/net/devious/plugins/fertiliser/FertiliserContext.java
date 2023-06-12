package net.devious.plugins.fertiliser;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import net.unethicalite.api.plugins.Task;

@RequiredArgsConstructor
public abstract class FertiliserContext implements Task
{
    @Delegate
    private final FertiliserPlugin context;
}

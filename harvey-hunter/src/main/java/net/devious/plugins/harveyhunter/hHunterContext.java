package net.devious.plugins.harveyhunter;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import net.unethicalite.api.plugins.Task;

@RequiredArgsConstructor
public abstract class hHunterContext implements Task
{
    @Delegate
    private final hHunterPlugin context;
}

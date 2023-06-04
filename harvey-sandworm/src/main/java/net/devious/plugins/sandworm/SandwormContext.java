package net.devious.plugins.sandworm;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import net.unethicalite.api.plugins.Task;

@RequiredArgsConstructor
public abstract class SandwormContext implements Task
{
    @Delegate
    private final SandwormPlugin context;
}

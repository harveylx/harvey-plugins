package net.devious.plugins.dynamite;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import net.unethicalite.api.plugins.Task;

@RequiredArgsConstructor
public abstract class DynamiteContext implements Task
{
    @Delegate
    private final DynamitePlugin context;
}

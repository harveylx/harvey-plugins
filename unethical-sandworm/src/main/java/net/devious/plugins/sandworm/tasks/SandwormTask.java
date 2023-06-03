package net.devious.plugins.sandworm.tasks;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import net.unethicalite.api.plugins.Task;
import net.devious.plugins.sandworm.SandwormPlugin;

@RequiredArgsConstructor
public abstract class SandwormTask implements Task
{
	@Delegate
	private final SandwormPlugin context;

	protected int taskCooldown;
}

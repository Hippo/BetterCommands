package rip.hippo.bettercommands.plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;
import rip.hippo.bettercommands.BetterCommand;
import rip.hippo.bettercommands.BetterCommands;
import rip.hippo.bettercommands.BukkitCommandAdapter;
import rip.hippo.bettercommands.adapter.TypeAdapterRegistry;
import rip.hippo.bettercommands.adapter.impl.StandardTypeAdapterRegistry;

import java.lang.reflect.Method;

/**
 * @author Hippo
 */
public final class BetterCommandsPlugin extends JavaPlugin implements BetterCommands {

  private final TypeAdapterRegistry typeAdapterRegistry;
  private static BetterCommands apiInstance;

  public BetterCommandsPlugin() {
    this.typeAdapterRegistry = new StandardTypeAdapterRegistry();
    apiInstance = this;
  }

  @Override
  public void registerCommand(BetterCommand betterCommand) {
    try {
      Method getCommandMap = Bukkit.getServer().getClass().getMethod("getCommandMap");
      CommandMap commandMap = (CommandMap) getCommandMap.invoke(Bukkit.getServer());
      commandMap.register(betterCommand.getName(), new BukkitCommandAdapter(this, betterCommand));
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void registerCommands(BetterCommand... betterCommands) {
    for (BetterCommand betterCommand : betterCommands) {
      registerCommand(betterCommand);
    }
  }

  @Override
  public TypeAdapterRegistry getTypeAdapterRegistry() {
    return typeAdapterRegistry;
  }

  public static BetterCommands getApiInstance() {
    return apiInstance;
  }
}

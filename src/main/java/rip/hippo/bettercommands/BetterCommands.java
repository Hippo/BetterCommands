package rip.hippo.bettercommands;

import rip.hippo.bettercommands.adapter.TypeAdapterRegistry;
import rip.hippo.bettercommands.plugin.BetterCommandsPlugin;

/**
 * @author Hippo
 */
public interface BetterCommands {
  void registerCommand(BetterCommand betterCommand);
  void registerCommands(BetterCommand... betterCommands);
  TypeAdapterRegistry getTypeAdapterRegistry();

  static BetterCommands getAPI() {
    return BetterCommandsPlugin.getApiInstance();
  }
}

package rip.hippo.bettercommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import rip.hippo.bettercommands.adapter.TypeAdapterRegistry;
import rip.hippo.bettercommands.annotation.CommandHandler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hippo
 */
public final class BukkitCommandAdapter extends Command {

  private final BetterCommand betterCommand;
  private final Map<Class<?>[], Method> methodParameterMap;
  private final TypeAdapterRegistry typeAdapterRegistry;

  public BukkitCommandAdapter(BetterCommands betterCommands, BetterCommand betterCommand) {
    super(betterCommand.getName());
    this.betterCommand = betterCommand;
    this.methodParameterMap = new HashMap<>();
    this.typeAdapterRegistry = betterCommands.getTypeAdapterRegistry();
    setDescription(betterCommand.getDescription());
    setAliases(betterCommand.getAliases());

    for (Method method : betterCommand.getClass().getMethods()) {
      CommandHandler annotation = method.getAnnotation(CommandHandler.class);
      if (annotation != null) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?>[] parameters = new Class<?>[parameterTypes.length - 1];
        System.arraycopy(parameterTypes, 1, parameters, 0, parameters.length);
        methodParameterMap.put(parameters,  method);
      }
    }
  }

  @Override
  public boolean execute(CommandSender sender, String commandLabel, String[] args) {
    Object[] arguments = new Object[args.length + 1];
    arguments[0] = sender;
    for (Class<?>[] parameters : methodParameterMap.keySet()) {
      if (parameters.length != args.length) continue;
      boolean found = true;
      for (int i = 0; i < parameters.length; i++) {
        Class<?> required = parameters[i];
        String arg = args[i];
        try {
          arguments[i + 1] = typeAdapterRegistry.getBinding(required).bind(arg);
        } catch (Throwable t) {
          found = false;
          break;
        }
      }
      if (!found) continue;
      try {
        methodParameterMap.get(parameters).invoke(betterCommand, arguments);
        return true;
      } catch (ReflectiveOperationException e) {
        sender.sendMessage(betterCommand.getHelpMessage());
        throw new RuntimeException(e);
      }
    }
    sender.sendMessage(betterCommand.getHelpMessage());
    return true;
  }
}

package rip.hippo.bettercommands;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Hippo
 */
public abstract class BetterCommand {

  private final String name;
  private final List<String> aliases = new LinkedList<>();

  public BetterCommand(String name) {
    this.name = name;
  }

  public abstract String getHelpMessage();
  public abstract String getDescription();

  protected void addAlias(String alias) {
    aliases.add(alias);
  }

  public String getName() {
    return name;
  }

  public List<String> getAliases() {
    return aliases;
  }
}

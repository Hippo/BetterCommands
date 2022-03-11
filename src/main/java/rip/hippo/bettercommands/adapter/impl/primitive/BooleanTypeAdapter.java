package rip.hippo.bettercommands.adapter.impl.primitive;

import rip.hippo.bettercommands.adapter.TypeAdapter;

import java.util.Locale;

/**
 * @author Hippo
 */
public final class BooleanTypeAdapter implements TypeAdapter<Boolean> {

  @Override
  public Boolean bind(String argument) {
    String check = argument.toLowerCase(Locale.ROOT);
    if (check.equals("true")) {
      return true;
    } else if (check.equals("false")) {
      return false;
    }
    throw new NumberFormatException("Boolean should only be true or false.");
  }
}

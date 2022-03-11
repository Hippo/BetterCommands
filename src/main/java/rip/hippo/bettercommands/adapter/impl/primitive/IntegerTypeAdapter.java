package rip.hippo.bettercommands.adapter.impl.primitive;

import rip.hippo.bettercommands.adapter.TypeAdapter;

/**
 * @author Hippo
 */
public final class IntegerTypeAdapter implements TypeAdapter<Integer> {
  @Override
  public Integer bind(String argument) {
    return Integer.parseInt(argument);
  }
}

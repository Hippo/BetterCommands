package rip.hippo.bettercommands.adapter.impl.primitive;

import rip.hippo.bettercommands.adapter.TypeAdapter;

/**
 * @author Hippo
 */
public final class ShortTypeAdapter implements TypeAdapter<Short> {
  @Override
  public Short bind(String argument) {
    return Short.parseShort(argument);
  }
}

package rip.hippo.bettercommands.adapter.impl.primitive;

import rip.hippo.bettercommands.adapter.TypeAdapter;

/**
 * @author Hippo
 */
public final class LongTypeAdapter implements TypeAdapter<Long> {
  @Override
  public Long bind(String argument) {
    return Long.parseLong(argument);
  }
}

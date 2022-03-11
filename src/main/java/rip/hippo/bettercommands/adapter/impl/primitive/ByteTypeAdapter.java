package rip.hippo.bettercommands.adapter.impl.primitive;

import rip.hippo.bettercommands.adapter.TypeAdapter;

/**
 * @author Hippo
 */
public final class ByteTypeAdapter implements TypeAdapter<Byte> {
  @Override
  public Byte bind(String argument) {
    return Byte.parseByte(argument);
  }
}

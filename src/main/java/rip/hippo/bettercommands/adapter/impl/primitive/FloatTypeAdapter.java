package rip.hippo.bettercommands.adapter.impl.primitive;

import rip.hippo.bettercommands.adapter.TypeAdapter;

/**
 * @author Hippo
 */
public final class FloatTypeAdapter implements TypeAdapter<Float> {
  @Override
  public Float bind(String argument) {
    return Float.parseFloat(argument);
  }
}

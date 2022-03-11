package rip.hippo.bettercommands.adapter.impl.primitive;

import rip.hippo.bettercommands.adapter.TypeAdapter;

/**
 * @author Hippo
 */
public final class DoubleTypeAdapter implements TypeAdapter<Double> {
  @Override
  public Double bind(String argument) {
    return Double.parseDouble(argument);
  }
}

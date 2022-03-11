package rip.hippo.bettercommands.adapter.impl;

import rip.hippo.bettercommands.adapter.TypeAdapter;

/**
 * @author Hippo
 */
public final class StringTypeAdapter implements TypeAdapter<String> {
  @Override
  public String bind(String argument) {
    return argument;
  }
}

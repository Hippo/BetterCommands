package rip.hippo.bettercommands.adapter.impl.primitive;

import rip.hippo.bettercommands.adapter.TypeAdapter;

/**
 * @author Hippo
 */
public final class CharacterTypeAdapter implements TypeAdapter<Character> {
  @Override
  public Character bind(String argument) {
    return argument.charAt(0);
  }
}

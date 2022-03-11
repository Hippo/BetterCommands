package rip.hippo.bettercommands.adapter;

/**
 * @author Hippo
 */
@FunctionalInterface
public interface TypeAdapter<T> {
  T bind(String argument);
}

package rip.hippo.bettercommands.adapter;

/**
 * @author Hippo
 */
public interface TypeAdapterRegistry {
  <T> void registerBinding(Class<T> bindClass, TypeAdapter<T> bindingAdapter);
  TypeAdapter<?> getBinding(Class<?> bindClass);
}

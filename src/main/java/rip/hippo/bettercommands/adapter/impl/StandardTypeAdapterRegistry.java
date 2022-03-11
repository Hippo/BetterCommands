package rip.hippo.bettercommands.adapter.impl;

import rip.hippo.bettercommands.adapter.TypeAdapter;
import rip.hippo.bettercommands.adapter.TypeAdapterRegistry;
import rip.hippo.bettercommands.adapter.impl.primitive.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hippo
 */
public final class StandardTypeAdapterRegistry implements TypeAdapterRegistry {

  private static final Map<Class<?>, Class<?>> PRIMITIVE_WRAPPER_MAP = new HashMap<>();

  private final Map<Class<?>, TypeAdapter<?>> registeredBindings = new HashMap<>();

  public StandardTypeAdapterRegistry() {
    registeredBindings.put(Boolean.class, new BooleanTypeAdapter());
    registeredBindings.put(Byte.class, new ByteTypeAdapter());
    registeredBindings.put(Character.class, new CharacterTypeAdapter());
    registeredBindings.put(Short.class, new ShortTypeAdapter());
    registeredBindings.put(Integer.class, new IntegerTypeAdapter());
    registeredBindings.put(Long.class, new LongTypeAdapter());
    registeredBindings.put(Float.class, new FloatTypeAdapter());
    registeredBindings.put(Double.class, new DoubleTypeAdapter());
    registeredBindings.put(String.class, new StringTypeAdapter());
  }

  @Override
  public <T> void registerBinding(Class<T> bindClass, TypeAdapter<T> bindingAdapter) {
    registeredBindings.put(bindClass, bindingAdapter);
  }

  @Override
  public TypeAdapter<?> getBinding(Class<?> bindClass) {
    bindClass = PRIMITIVE_WRAPPER_MAP.getOrDefault(bindClass, bindClass);
    return registeredBindings.get(bindClass);
  }

  static {
    PRIMITIVE_WRAPPER_MAP.put(boolean.class, Boolean.class);
    PRIMITIVE_WRAPPER_MAP.put(byte.class, Byte.class);
    PRIMITIVE_WRAPPER_MAP.put(char.class, Character.class);
    PRIMITIVE_WRAPPER_MAP.put(short.class, Short.class);
    PRIMITIVE_WRAPPER_MAP.put(int.class, Integer.class);
    PRIMITIVE_WRAPPER_MAP.put(long.class, Long.class);
    PRIMITIVE_WRAPPER_MAP.put(float.class, Float.class);
    PRIMITIVE_WRAPPER_MAP.put(double.class, Double.class);
  }
}

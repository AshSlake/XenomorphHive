package ecs.entities;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Entity {
    private int id;
    private final Map<Class<?>, ecs.components.Component> components = new HashMap<>();

    public void addComponent(ecs.components.Component component) {
        components.put(component.getClass(), component);
    }

    public <T extends ecs.components.Component> T getComponent(Class<T> componentClass) {
        return componentClass.cast(components.get(componentClass));
    }
}

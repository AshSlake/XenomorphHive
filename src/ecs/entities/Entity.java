package ecs.entities;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Entity {
    private int id;
    private final Map<Class<?>, Component> components = new HashMap<>();

    public void addComponent(Component component) {
        components.put(component.getClass(), component);
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        return componentClass.cast(components.get(componentClass));
    }
}

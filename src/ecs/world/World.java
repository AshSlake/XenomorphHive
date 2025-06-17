package ecs.world;

import ecs.entities.Entity;

import java.util.List;

public class World {
    private List<Entity> entities;
    private List<ecs.systems.System> systems;

    public void addEntity(Entity entity) {}
    public void addSystem(System system) {}

    public void update() {
        for (ecs.systems.System system : systems) {
            system.update (entities);
        }
    }
}

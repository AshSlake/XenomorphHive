package ecs.systems;

import ecs.entities.Entity;

import java.util.List;

public interface System {
    void update(List<Entity> entities);
}

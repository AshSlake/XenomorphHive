package ecs.factory;

import ecs.components.HealthComponent;
import ecs.components.PositionComponent;
import ecs.entities.Entity;

public class FacehuggerFactory {

    public static Entity createFacehugger(float x, float y) {
        Entity facehugger = new Entity();
        facehugger.addComponent(new PositionComponent(x, y));
        facehugger.addComponent(new HealthComponent(25));
        facehugger.setIdTypeComponent(1);
        return facehugger;
    }
}

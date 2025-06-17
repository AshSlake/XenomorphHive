package ecs.factory;

import com.sun.jdi.TypeComponent;
import ecs.components.HealthComponent;
import ecs.components.IncubationComponent;
import ecs.components.PositionComponent;
import ecs.entities.Entity;
import utils.PositionGenerator;

public class EggFactory {

    public static Entity createRandom() {
        float[] position = PositionGenerator.generateRandomPosition();
        return create(position[0], position[1]);
    }

    public static Entity create(float x, float y) {
        Entity egg = new Entity();
        egg.addComponent(new PositionComponent(x, y));
        egg.addComponent(new IncubationComponent(10f));
        egg.addComponent(new HealthComponent(10));
        return egg;
    }
}



package ecs.factory;

import ecs.components.HealthComponent;
import ecs.components.IncubationComponent;
import ecs.components.LifecycleComponent;
import ecs.components.PositionComponent;
import ecs.entities.Entity;
import model.enums.XenoPhase;
import utils.PositionGenerator;

public class EggFactory {
    private static final XenoPhase xenoPhase = XenoPhase.EGG;

    public static Entity createRandom() {
        float[] position = PositionGenerator.generateRandomPosition();
        return create(position[0], position[1]);
    }

    public static Entity create(float x, float y) {
        Entity egg = new Entity();
        egg.setIdTypeComponent(0);
        egg.addComponent(new PositionComponent(x, y));
        egg.addComponent(new IncubationComponent(10f));
        egg.addComponent(new LifecycleComponent(xenoPhase));
        egg.addComponent(new HealthComponent(egg.getComponent(LifecycleComponent.class).getMaxHealth()));
        return egg;
    }
}



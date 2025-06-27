package ecs.factory;

import ecs.components.*;
import ecs.entities.Entity;
import model.enums.XenoPhase;
import model.enums.XenoType;
import utils.PositionGenerator;

public class EggFactory {
    private static final XenoPhase xenoPhase = XenoPhase.EGG;
    private static final XenoType xenoType = XenoType.EGG;

    public static Entity createRandom() {
        PositionGenerator cordenadas = PositionGenerator.ramdom(100,100);
        int x = cordenadas.x;
        int y = cordenadas.y;
        return create(x,y);
    }

    public static Entity create(int x, int y) {
        Entity egg = new Entity();
        egg.setIdTypeComponent(0);
        egg.addComponent(new XenomorphComponent(xenoType,true,0));
        egg.addComponent(new AcidComponent());
        egg.addComponent(new LifecycleComponent(xenoPhase));
        egg.addComponent(new HealthComponent(egg.getComponent(LifecycleComponent.class).getMaxHealth()));
        egg.addComponent(new PositionComponent(x, y));
        egg.addComponent(new IncubationComponent(10));
        return egg;
    }
}



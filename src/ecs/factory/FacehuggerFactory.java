package ecs.factory;

import ecs.components.*;
import ecs.entities.Entity;
import model.enums.XenoPhase;
import model.enums.XenoType;

public class FacehuggerFactory {
    private static final XenoType xenoType = XenoType.FACEHUGGER;
    private static final XenoPhase xenoPhase = XenoPhase.FACEHUGGER;


    public static Entity createFacehugger(int x, int y) {
        Entity facehugger = new Entity();
        facehugger.addComponent(new XenomorphComponent(xenoType,true,0));
        facehugger.addComponent(new PositionComponent(x, y));
        facehugger.addComponent(new LifecycleComponent(xenoPhase));
        facehugger.addComponent(new HealthComponent(facehugger.getComponent(LifecycleComponent.class).getHealth()));
        facehugger.addComponent(new AcidComponent());
        facehugger.setIdTypeComponent(1);
        return facehugger;
    }
}

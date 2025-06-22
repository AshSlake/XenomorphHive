package ecs.factory;

import ecs.components.*;
import ecs.entities.Entity;
import model.enums.XenoPhase;
import model.enums.XenoType;

public class ChestbursterFactory {

    private static XenoPhase xenoPhase = XenoPhase.CHESTBURSTER;
    private static XenoType xenoType = XenoType.CHESTBURSTER;

    public static Entity createChestburster(float x, float y) {

        Entity chestburster = new Entity();
        chestburster.addComponent(new XenomorphComponent(xenoType));
        chestburster.addComponent(new AcidComponent());
        chestburster.addComponent(new PositionComponent(x,y));
        chestburster.addComponent(new LifecycleComponent(xenoPhase));
        chestburster.addComponent(new HealthComponent(chestburster.getComponent(LifecycleComponent.class).getHealth()));
        chestburster.setIdTypeComponent(2);
        return chestburster;
    }

    public static XenoPhase getXenoPhase() {
        return xenoPhase;
    }

    public static void setXenoPhase(XenoPhase xenoPhase) {
        ChestbursterFactory.xenoPhase = xenoPhase;
    }

    public static XenoType getXenoType() {
        return xenoType;
    }

    public static void setXenoType(XenoType xenoType) {
        ChestbursterFactory.xenoType = xenoType;
    }
}

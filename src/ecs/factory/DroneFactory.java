package ecs.factory;

import ecs.components.*;
import ecs.entities.Entity;
import model.enums.XenoPhase;
import model.enums.XenoType;

public class DroneFactory {

    private static XenoPhase xenoPhase = XenoPhase.ADULT;
    private static XenoType xenoType = XenoType.DRONE;

    public static Entity createDrone(int x, int y) {

        Entity drone = new Entity();
        drone.addComponent(new XenomorphComponent(xenoType));
        drone.addComponent(new AcidComponent());
        drone.addComponent(new PositionComponent(x,y));
        drone.addComponent(new LifecycleComponent(xenoPhase));
        drone.addComponent(new HealthComponent(drone.getComponent(LifecycleComponent.class).getHealth()));
        drone.setIdTypeComponent(2);
        return drone;
    }

    public static XenoPhase getXenoPhase() {
        return xenoPhase;
    }

    public static void setXenoPhase(XenoPhase xenoPhase) {
        DroneFactory.xenoPhase = xenoPhase;
    }

    public static XenoType getXenoType() {
        return xenoType;
    }

    public static void setXenoType(XenoType xenoType) {
        DroneFactory.xenoType = xenoType;
    }
}

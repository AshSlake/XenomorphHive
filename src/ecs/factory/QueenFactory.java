package ecs.factory;

import ecs.components.*;
import ecs.entities.Entity;
import model.enums.XenoPhase;
import model.enums.XenoType;

public class QueenFactory {

    private static XenoPhase xenoPhase = XenoPhase.QUEEN;
    private static XenoType xenoType = XenoType.QUEEN;

    public static Entity createQueen(int x, int y) {

        Entity quenn = new Entity();
        quenn.addComponent(new XenomorphComponent(xenoType,true,0));
        quenn.addComponent(new AcidComponent());
        quenn.addComponent(new PositionComponent(x,y));
        quenn.addComponent(new LifecycleComponent(xenoPhase));
        quenn.addComponent(new HealthComponent(quenn.getComponent(LifecycleComponent.class).getHealth()));
        quenn.setIdTypeComponent(4);
        return quenn;
    }

    public static XenoPhase getXenoPhase() {
        return xenoPhase;
    }

    public static void setXenoPhase(XenoPhase xenoPhase) {
        QueenFactory.xenoPhase = xenoPhase;
    }

    public static XenoType getXenoType() {
        return xenoType;
    }

    public static void setXenoType(XenoType xenoType) {
        QueenFactory.xenoType = xenoType;
    }
}

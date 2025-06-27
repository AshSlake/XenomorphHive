package ecs.factory;

import ecs.components.CombatComponent;
import ecs.components.HealthComponent;
import ecs.components.HostIncubationComponent;
import ecs.components.PositionComponent;
import ecs.entities.Entity;

import java.util.UUID;

public class HumanFactory {

    private static UUID humanId;

    public Entity createHuman(int x, int y) {

        Entity human = new Entity();
        human.addComponent(new HealthComponent(100));
        human.addComponent(new CombatComponent());
        human.addComponent(new PositionComponent(x, y));
        human.addComponent(new HostIncubationComponent());
        return human;
    }

    public HumanFactory() {
        humanId = UUID.randomUUID();
    }

    public static UUID getHumanId() {
        return humanId;
    }

    public static void setHumanId(UUID humanId) {
        HumanFactory.humanId = humanId;
    }
}

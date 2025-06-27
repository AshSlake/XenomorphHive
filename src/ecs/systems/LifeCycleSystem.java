package ecs.systems;

import ecs.components.LifecycleComponent;
import ecs.components.PositionComponent;
import ecs.entities.Entity;
import ecs.factory.DroneFactory;
import ecs.factory.FacehuggerFactory;
import ecs.factory.QueenFactory;
import model.enums.XenoPhase;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class LifeCycleSystem implements System {

    @Override
    public void update (List<Entity> entities) {
        float deltaTime = 1f;

        Iterator<Entity> iterator  = entities.iterator();
        Collection<Entity> toAdd = new java.util.ArrayList<>(List.of());

        while (iterator.hasNext()) {
            Entity entity = iterator.next();

            if (!entity.hasComponent(LifecycleComponent.class)) continue;

            LifecycleComponent life = entity.getComponent(LifecycleComponent.class);
            life.update(deltaTime);

            if (!life.isReadyToEvolve()) continue;

            PositionComponent pos = entity.getComponent(PositionComponent.class);
            int x = pos != null ? pos.getX() : 0;
            int y = pos != null ? pos.getY() : 0;

            XenoPhase currentPhase = life.getCurrentPhase();
            Entity next = null;

            if (Objects.requireNonNull(currentPhase) == XenoPhase.CHESTBURSTER) {
                boolean queenExists = entities.stream().anyMatch(e ->
                        e.hasComponent(LifecycleComponent.class) &&
                                e.getComponent(LifecycleComponent.class).getCurrentPhase() == XenoPhase.QUEEN);

                if (!queenExists) {
                    next = QueenFactory.createQueen(x, y);
                    java.lang.System.out.println("[EVOLUÇÃO] Chestburster evoluiu para QUEEN em (\" + x + \", \" + y + \")");
                    continue;
                }
                next = DroneFactory.createDrone(x, y);
                java.lang.System.out.println("[EVOLUÇÃO] Chestburster evoluiu para DRONE em (\" + x + \", \" + y + \")");

                toAdd.add(next);
            }
        }
        // após sair do loop adiciona as entidades contidas no toAdd.
        entities.addAll(toAdd);
    }
}

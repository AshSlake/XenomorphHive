package ecs.systems;

import ecs.components.HostIncubationComponent;
import ecs.components.PositionComponent;
import ecs.entities.Entity;
import ecs.factory.ChestbursterFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HostIcubationSytem implements System {

    @Override
    public void update (List<Entity> entities) {

        Iterator<Entity> iterator = entities.iterator();

        Collection<Entity> toAdd = new ArrayList<>(List.of());

        while (iterator.hasNext()) {
            Entity e = iterator.next();

            if (!e.hasComponent(HostIncubationComponent.class)) continue;

            HostIncubationComponent hic = e.getComponent(HostIncubationComponent.class);
            float deltaTime = 2.5f;
            hic.update(deltaTime);

            if (hic.isReadyToBurst()) {

                // pega a posição do hospedeiro
                PositionComponent position = e.getComponent(PositionComponent.class);
                float x = position.getX();
                float y = position.getY();

                java.lang.System.out.println("[GESTAÇÃO] 💥 Chestburster irrompeu do hospedeiro!  em (" + x + ", " + y + ")");

                // marca o facehugger para ser deletado do mundo.
                e.markForRemoval();

                // cria o Chestburster no lugar onde estava o hospedeiro.
                Entity Chestburster = ChestbursterFactory.createChestburster(x,y);

                // adiciona o Chestburster ao toAdd para evitar Exception.
                toAdd.add(Chestburster);
            }
        }
        // apos sair do loop adiciona as novas entidades.
        entities.addAll(toAdd);
    }
}

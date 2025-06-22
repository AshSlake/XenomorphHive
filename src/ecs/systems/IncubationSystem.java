package ecs.systems;

import ecs.components.IncubationComponent;
import ecs.components.PositionComponent;
import ecs.entities.Entity;
import ecs.factory.FacehuggerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IncubationSystem implements System{

    @Override
    public void update (List<Entity> entities) {
        Iterator<Entity> iterator  = entities.iterator();

        Collection<Entity> toAdd = new java.util.ArrayList<>(List.of());
        while(iterator.hasNext()) {
            Entity entity = iterator.next();

            if (!entity.hasComponent(IncubationComponent.class)) continue;

            IncubationComponent incubation = entity.getComponent(IncubationComponent.class);
            float deltaTime = 1f;
            incubation.update(deltaTime);

            if (incubation.isReadyToHatch()) {
                //pega a posição do ovo

                PositionComponent position = entity.getComponent(PositionComponent.class);
                float x = (position != null) ? position.getX() : 0f;
                float y = (position != null) ? position.getY() : 0f;

                java.lang.System.out.println("[INCUBAÇÂO] Ovo eclodiu em Facehugger! Posição: (" + x + ", " + y + ")");

                //remove o ovo
                entity.markForRemoval();

                //cria o facehugger na mesma posição
                Entity facehugger = FacehuggerFactory.createFacehugger(x,y);
                toAdd.add(facehugger);
            }
        }

        entities.addAll(toAdd);
    }
}

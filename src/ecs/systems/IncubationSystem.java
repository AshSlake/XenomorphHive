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

        // utilizado para adicionar um novo facehugger sem quebrar o contrato do iterator.
        Collection<Entity> toAdd = new java.util.ArrayList<>(List.of());


        while(iterator.hasNext()) {
            Entity entity = iterator.next();

            // caso a entidade selecionada não contenha o componente de incubação ele pula ela e itinera sobre a proxima.
            if (!entity.hasComponent(IncubationComponent.class)) continue;

            IncubationComponent incubation = entity.getComponent(IncubationComponent.class);
            float deltaTime = 1f;
            incubation.update(deltaTime);

            // caso a entidade esteja pronta para eclodir;
            if (incubation.isReadyToHatch()) {
                //pega a posição do ovo

                PositionComponent position = entity.getComponent(PositionComponent.class);
                float x = (position != null) ? position.getX() : 0f;
                float y = (position != null) ? position.getY() : 0f;

                java.lang.System.out.println("[INCUBAÇÂO] Ovo eclodiu em Facehugger! Posição: (" + x + ", " + y + ")");

                //marca a entidade para ser removida.
                entity.markForRemoval();

                //cria o facehugger na mesma posição
                Entity facehugger = FacehuggerFactory.createFacehugger(x,y);

                //adiciona o facehugger no toAdd para evitar exeption.
                toAdd.add(facehugger);
            }
        }
        // após sair do loop adiciona as entidades contidas no toAdd.
        entities.addAll(toAdd);
    }
}

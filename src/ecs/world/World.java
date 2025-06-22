package ecs.world;

import ecs.components.Component;
import ecs.entities.Entity;
import ecs.systems.System;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class World {
    private List<Entity> entities;
    private List<ecs.systems.System> systems;

    public World() {
        this.entities = new ArrayList<>();
        this.systems = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        if (entity != null && !entities.contains(entity)) {
            entities.add(entity);
            java.lang.System.out.println(entity.getClass().getName() + " added to world");
        }
    }

    public void removeEntity(Entity entity) {
        if (entity != null && !entities.contains(entity)) {
            entities.remove(entity);
        }
    }

    public void addSystem(System system) {
        if (system != null && !systems.contains(system)) {
            systems.add(system);
            java.lang.System.out.println(system.getClass().getName() + " added to world");
        }
    }

    public void removeSystem(System system) {
        if (system != null && !systems.contains(system)) {
            systems.remove(system);
        }
    }

    public void update() {
        for (System system : systems) {
            cleanup();
            system.update(entities);

        }
    }

    /**
     * Retorna lista imutável de todas as entidades no mundo.
     */
    public void printEntities() {
        List<Entity> snapshot = List.copyOf(entities);

        java.lang.System.out.println("=== Entidades Atuais no Mundo ===");

        if (snapshot.isEmpty()) {
            java.lang.System.out.println("Nenhuma entidade no momento");
            return;
        }

        for (Entity entity : snapshot) {
            String id = "Entidade #" + entity.getId();
            java.lang.System.out.println(id);

            Map<Class<?>, Component> components = entity.getAllComponents();

            if (components.isEmpty()) {
                java.lang.System.out.println("Nenhum componente no momento");
                return;
            }

            for (Map.Entry<Class<?>, Component> entry : components.entrySet()) {
                int typeEntitie = entity.getIdTypeComponent();
                String nomeEntity = null;
                if (typeEntitie > -1) {
                    nomeEntity = switch (typeEntitie) {
                        case 0 -> "Egg";
                        case 1 -> "Facehugger";
                        default -> nomeEntity;
                    };
                }
                String nomeComponente = entry.getKey().getSimpleName();
                String valor = entry.getValue().toString();
                java.lang.System.out.println(id + " " + nomeEntity + " " + nomeComponente + " " + valor);
            }
            java.lang.System.out.println();
        }

        java.lang.System.out.println("=== FIM DA LISTA ===");

    }

    /**
     * Faz loop interno e remove entidades marcadas como mortas ou removidas.
     * Útil para coletar sobras após systems.
     */
    public void cleanup() {
        entities.removeIf(Entity :: isRemoved);
    }
}


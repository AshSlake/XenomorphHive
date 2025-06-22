package main;

import ecs.entities.Entity;
import ecs.factory.EggFactory;
import ecs.systems.IncubationSystem;
import ecs.world.World;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        World world = new World();
        // Adiciona um ovo inicial
        Entity egg = EggFactory.createRandom();
        world.addEntity(egg);

        // Registra sistemas
        world.addSystem(new IncubationSystem());


        // Loop principal
        for (int tick = 0; tick < 50; tick++) {
            System.out.println("--- Tick " + tick + " ---");
                    world.update();
                    world.printEntities();


            Thread.sleep(500);
        }
    }
}
